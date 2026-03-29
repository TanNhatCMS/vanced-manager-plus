package com.app.manager.data.manager

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Environment
import androidx.documentfile.provider.DocumentFile
import com.app.manager.core.di.NetworkModule.DownloadClient
import com.app.manager.data.local.preferences.PreferencesManager
import com.app.manager.domain.model.AppDownload
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException
import java.io.FileInputStream
import java.io.File
import java.io.FileOutputStream
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SimpleDownloadManager @Inject constructor(
    @ApplicationContext private val context: Context,
    @DownloadClient private val okHttpClient: OkHttpClient,
    private val preferencesManager: PreferencesManager
) {
    private val activeDownloads = ConcurrentHashMap<String, AppDownload>()

    fun getActiveDownloads(): Map<String, AppDownload> = activeDownloads.toMap()

    fun cancelDownload(packageName: String) {
        activeDownloads.remove(packageName)
    }

    fun downloadApp(packageName: String, downloadUrl: String): Flow<AppDownload> = flow {
        val configuredPath = runCatching { preferencesManager.getAppConfig().downloadPath }.getOrDefault("")
        val internalDir = File(context.cacheDir, "downloads").apply { mkdirs() }
        val outputFile = File(internalDir, "$packageName.apk")

        val request = Request.Builder().url(downloadUrl).build()
        val call = okHttpClient.newCall(request)
        val response = call.execute()

        if (!response.isSuccessful) {
            throw IOException("Download failed with code ${response.code}")
        }

        val body = response.body ?: throw IOException("Response body is empty")
        val totalBytes = body.contentLength().coerceAtLeast(1L)

        body.byteStream().use { input ->
            FileOutputStream(outputFile).use { output ->
                val buffer = ByteArray(DEFAULT_BUFFER_SIZE)
                var bytesCopied = 0L

                while (true) {
                    val read = input.read(buffer)
                    if (read < 0) break
                    output.write(buffer, 0, read)
                    bytesCopied += read

                    val progress = (bytesCopied.toFloat() / totalBytes.toFloat()).coerceIn(0f, 1f)
                    val item = AppDownload(
                        packageName = packageName,
                        url = downloadUrl,
                        filePath = outputFile.absolutePath,
                        progress = progress,
                        isComplete = false
                    )
                    activeDownloads[packageName] = item
                    emit(item)
                }
            }
        }

        val completed = AppDownload(
            packageName = packageName,
            url = downloadUrl,
            filePath = outputFile.absolutePath,
            progress = 1f,
            isComplete = true
        )

        activeDownloads[packageName] = completed
        emit(completed)

        // Export a copy to user-configured folder (filesystem path or SAF tree URI).
        runCatching {
            exportDownloadedApk(outputFile, configuredPath, packageName)
        }

        val completedIntent = Intent(DownloadService.ACTION_DOWNLOAD_COMPLETE).apply {
            putExtra(DownloadService.EXTRA_PACKAGE_NAME, packageName)
            putExtra(DownloadService.EXTRA_FILE_PATH, outputFile.absolutePath)
        }
        context.sendBroadcast(completedIntent)

        activeDownloads.remove(packageName)
    }.flowOn(Dispatchers.IO)

    private fun resolveDownloadDirectory(configuredPath: String): File {
        val candidates = mutableListOf<File>()

        if (configuredPath.isNotBlank()) {
            candidates.add(File(configuredPath))
        } else {
            if (canWriteSharedStorage()) {
                candidates.add(File(Environment.getExternalStorageDirectory(), "AppManager"))
            }
            candidates.add(File(context.getExternalFilesDir(null), "AppManager"))
        }
        candidates.add(File(context.cacheDir, "downloads"))

        for (candidate in candidates) {
            if (ensureUsableDirectory(candidate)) {
                return candidate
            }
        }

        return File(context.cacheDir, "downloads").apply { mkdirs() }
    }

    private fun exportDownloadedApk(sourceFile: File, configuredPath: String, packageName: String) {
        if (configuredPath.startsWith("content://")) {
            exportToTreeUri(sourceFile, configuredPath, "$packageName.apk")
            return
        }

        val exportDir = resolveDownloadDirectory(configuredPath)
        val target = File(exportDir, "$packageName.apk")
        sourceFile.copyTo(target, overwrite = true)
    }

    private fun exportToTreeUri(sourceFile: File, treeUriString: String, fileName: String) {
        val treeUri = Uri.parse(treeUriString)
        val tree = DocumentFile.fromTreeUri(context, treeUri) ?: return
        if (!tree.canWrite()) return

        tree.findFile(fileName)?.delete()
        val target = tree.createFile("application/vnd.android.package-archive", fileName) ?: return

        context.contentResolver.openOutputStream(target.uri)?.use { output ->
            FileInputStream(sourceFile).use { input ->
                input.copyTo(output)
            }
        }
    }

    private fun canWriteSharedStorage(): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.R || Environment.isExternalStorageManager()
    }

    private fun ensureUsableDirectory(directory: File): Boolean {
        return try {
            if (!directory.exists() && !directory.mkdirs()) {
                return false
            }
            if (!directory.isDirectory) {
                return false
            }
            val probe = File(directory, ".probe")
            if (probe.exists()) {
                probe.delete()
            }
            probe.writeText("ok")
            probe.delete()
            true
        } catch (_: Exception) {
            false
        }
    }
}

