# RV Manager Plus 3.0 🚀

## 🌟 Apresentando o RV Manager Plus 3.0

Um aplicativo Android completamente redesenhado para gerenciar aplicações modificadas com arquitetura moderna, experiência do usuário aprimorada e recursos de nível profissional.

![Tela Principal](../screenshots/main_screen.jpg)

### ✨ Novidades na Versão 3.0

O RV Manager Plus 3.0 representa uma reformulação completa das versões anteriores, resolvendo todos os principais problemas e introduzindo recursos revolucionários:

## 🎯 Recursos Principais e Melhorias

### 🌍 **Suporte Multilíngue Abrangente (20+ Idiomas)**
- **Traduções Profissionais**: Suporte nativo para 20+ idiomas incluindo Inglês, Vietnamita, Chinês, Hindi, Indonésio, Espanhol, Coreano, Francês, Alemão e mais
- **Seletor de Idioma Visual**: Belos ícones de bandeiras com troca de idioma intuitiva
- **Reinicialização Automática Inteligente**: Reinicialização automática do aplicativo ao alterar idiomas para experiência fluida

### 🎨 **Interface Material Design 3 Moderna**
- **Temas Adaptativos**: Suporte completo para temas Claro, Escuro e do Sistema
- **Material You**: Esquemas de cores dinâmicos que se adaptam ao seu dispositivo
- **Design Responsivo**: Otimizado para todos os tamanhos de tela e orientações
- **UI/UX Profissional**: Interface limpa e intuitiva seguindo as últimas diretrizes de design do Google

### 🚀 **Sistema de Download Revolucionário**
**Reescrita completa corrigindo todos os problemas de download anteriores:**

- **✅ OutOfMemoryError Corrigido**: Eliminados crashes ao baixar arquivos grandes
- **✅ Downloads em Segundo Plano**: Downloads continuam perfeitamente quando o app é minimizado
- **✅ Downloads Simultâneos**: Baixe múltiplos aplicativos simultaneamente
- **✅ Progresso em Tempo Real**: Acompanhamento de progresso ao vivo com exibição de velocidade e ETA
- **✅ Lógica de Tentativa Inteligente**: Mecanismo de tentativa inteligente para downloads falhados
- **✅ Validação de Armazenamento**: Verificação de espaço de armazenamento antes do download

### 🔧 **Sistema de Instalação Aprimorado**
**Completamente resolvidos todos os problemas de instalação das versões anteriores:**

#### **Monitoramento de Instalação em Segundo Plano**
- **Gerenciamento de Estado Persistente**: Downloads e instalações rastreados em banco de dados local
- **Auto-Instalação no Retorno**: Ao retornar do segundo plano, downloads concluídos são instalados automaticamente
- **Solicitações de Instalação Imediatas**: Múltiplos diálogos de instalação podem aparecer simultaneamente
- **Detecção de Cancelamento Inteligente**: Detecção instantânea quando usuário cancela instalação (3 segundos vs 65 segundos)
- **Tratamento de Interrupção do Usuário**: Diferenciação inteligente entre cancelamento do usuário e erros do sistema

#### **Recuperação de Erro Robusta**
- **Tentativa com Desinstalação**: Remoção automática da versão antiga antes de tentar instalação novamente
- **Monitoramento de Instalação**: Acompanhamento de status de instalação em tempo real com tratamento de timeout
- **Categorização de Erros**: Tratamento específico de erro para diferentes tipos de falhas
- **Recuperação Limpa**: Limpeza adequada de instalações falhadas e downloads parciais

### 🏗️ **Implementação de Arquitetura Limpa**
**Arquitetura de software profissional seguindo padrões da indústria:**

- **Arquitetura Limpa**: Separação das camadas de Apresentação, Domínio e Dados
- **Padrão BLoC**: Gerenciamento de estado previsível com atualizações de UI reativas
- **Injeção de Dependência**: DI alimentado por Hilt para acoplamento frouxo e testabilidade
- **Padrão Repository**: Gerenciamento de dados centralizado com suporte a cache
- **Casos de Uso**: Lógica de negócio isolada para melhor manutenibilidade

## 🔥 **Principais Correções de Bugs e Melhorias**

### **Reformulação do Sistema de Download**
- **❌ Corrigido**: Crashes OutOfMemoryError durante downloads de arquivos grandes
- **❌ Corrigido**: Downloads não retomam após reinicialização do app
- **❌ Corrigido**: Barra de progresso não atualiza corretamente
- **❌ Corrigido**: Downloads falhando em redes lentas
- **❌ Corrigido**: Conflitos de download simultâneo

### **Reconstrução do Sistema de Instalação**
- **❌ Corrigido**: Apps não instalam após conclusão do download
- **❌ Corrigido**: Problemas de timeout de instalação (atrasos de 65+ segundos)
- **❌ Corrigido**: Múltiplas solicitações de instalação se bloqueando mutuamente
- **❌ Corrigido**: Fila de download perdida quando app vai para segundo plano
- **❌ Corrigido**: Exibição de status incorreta após falha de instalação
- **❌ Corrigido**: Mecanismo de tentativa não funcionando adequadamente

## 🛠️ **Stack Tecnológico**

### **Desenvolvimento Android Moderno**
- **Kotlin 2.0.21**: Recursos de linguagem mais recentes e melhorias de performance
- **Jetpack Compose**: Framework de UI declarativo moderno
- **Material Design 3**: Sistema de design mais recente do Google
- **Android Gradle Plugin 8.8.2**: Ferramentas de build de ponta

### **Arquitetura e Padrões**
- **Arquitetura Limpa**: Design orientado por domínio com separação clara
- **Padrão BLoC**: Gerenciamento de estado previsível
- **Padrão Repository**: Acesso a dados centralizado
- **Padrão Use Case**: Lógica de negócio isolada
- **Injeção de Dependência**: Container DI alimentado por Hilt

## 📋 **Requisitos do Sistema**

- **Versão Android**: 7.0 (API 24) ou superior
- **RAM**: 4GB recomendado para performance ótima
- **Armazenamento**: 100MB de espaço livre para app + downloads
- **Rede**: Conexão com internet para downloads
- **Permissões**: Instalar apps desconhecidos, Acesso ao armazenamento

## 🚀 **Guia de Instalação**

### **Método 1: Download Direto do APK**
1. Baixe o APK mais recente de [Releases](https://github.com/vancedto/vanced-manager-plus/releases)
2. Habilite "Instalar de fontes desconhecidas" nas configurações do Android
3. Instale o arquivo APK
4. Conceda as permissões necessárias

### **Método 2: Construir do Código Fonte**
```bash
# Clonar o repositório
git clone https://github.com/vancedto/vanced-manager-plus.git
cd rv-manager

# Construir versão debug
./gradlew assembleDebug

# Construir versão release (requer keystore)
./gradlew assembleRelease
```

## 🎮 **Como Usar**

### **Primeira Inicialização**
1. **Seleção de Idioma**: Escolha seu idioma preferido dentre 20+ opções
2. **Seleção de Tema**: Escolha tema Claro, Escuro ou do Sistema
3. **Permissões**: Conceda permissões de armazenamento e instalação
4. **Lista de Apps**: Navegue pelos aplicativos disponíveis

### **Baixando Aplicativos**
1. **Navegar**: Veja apps disponíveis com indicadores de status
2. **Baixar**: Toque no botão de download para apps desejados
3. **Segundo Plano**: App pode ser minimizado - downloads continuam
4. **Auto-Instalação**: Retorne ao app para solicitações de instalação automática

### **Gerenciar Aplicativos**
- **Instalar**: Instale aplicativos baixados
- **Atualizar**: Atualize apps existentes para versões mais recentes
- **Desinstalar**: Remova apps que não precisa mais
- **Abrir**: Inicie aplicativos instalados

## 🌐 **Idiomas Suportados**

| Idioma | Código | Nome Nativo |
|----------|------|-------------|
| 🇬🇧 Inglês | en | English |
| 🇻🇳 Vietnamita | vi | Tiếng Việt |
| 🇨🇳 Chinês | zh | 中文 |
| 🇮🇳 Hindi | hi | हिन्दी |
| 🇮🇩 Indonésio | id | Bahasa Indonesia |
| 🇧🇷 Português | pt | Português (Brasil) |
| 🇹🇷 Turco | tr | Türkçe |
| 🇲🇽 Espanhol | es | Español (México) |
| 🇰🇷 Coreano | ko | 한국어 |
| 🇫🇷 Francês | fr | Français |
| 🇵🇱 Polonês | pl | Polski |
| 🇩🇪 Alemão | de | Deutsch |
| E mais 8+... | | |

## 🛡️ **Segurança e Privacidade**

- **Nenhuma Coleta de Dados**: App não coleta dados pessoais
- **Armazenamento Local**: Todas as preferências são armazenadas localmente
- **Downloads Seguros**: Apenas downloads HTTPS com verificação de integridade
- **Gerenciamento de Permissões**: Permissões mínimas necessárias
- **Código Aberto**: Código disponível para auditoria de segurança

## 🤝 **Contribuindo**

Damos as boas-vindas a contribuições da comunidade!

### **Como Contribuir**
1. **Fork** o repositório
2. **Criar** um branch de feature
3. **Fazer** suas alterações
4. **Testar** minuciosamente
5. **Enviar** um pull request

## 📝 **Log de Alterações**

### **Versão 3.0.0 (Mais Recente)**
- ✅ Reescrita completa do aplicativo
- ✅ Corrigidos todos os problemas de download e instalação
- ✅ Adicionado suporte para 20+ idiomas
- ✅ Implementado Material Design 3
- ✅ Melhorado gerenciamento de download em segundo plano
- ✅ Adicionada funcionalidade de auto-instalação
- ✅ Melhorado tratamento de erros e feedback do usuário

## 🆘 **Suporte e Solução de Problemas**

### **Problemas Comuns**
- **Download Falha**: Verifique conexão com internet e espaço de armazenamento
- **Instalação Bloqueada**: Habilite "Instalar de fontes desconhecidas"
- **App Trava**: Limpe dados do app e reinicie
- **Idioma Não Muda**: Reinicie o app após seleção de idioma

### **Obtendo Ajuda**
- **GitHub Issues**: [Relatar bugs ou solicitar recursos](https://github.com/vancedto/vanced-manager-plus/issues)
- **Documentação**: Verifique este README e wiki
- **Comunidade**: Participe de discussões na seção Issues

## 📄 **Licença**

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para detalhes.

## 🙏 **Agradecimentos**

- **Comunidade Android**: Pelas bibliotecas e ferramentas de código aberto
- **Contribuidores**: Todos que ajudaram a melhorar este aplicativo
- **Testadores**: Membros da comunidade que forneceram feedback
- **Tradutores**: Contribuidores que forneceram traduções de idiomas

## 🔗 **Links**

- **Homepage**: [https://vanced.to](https://vanced.to)
- **Repositório**: [https://github.com/vancedto/vanced-manager-plus](https://github.com/vancedto/vanced-manager-plus)
- **Releases**: [Downloads Mais Recentes](https://github.com/vancedto/vanced-manager-plus/releases)
- **Issues**: [Relatórios de Bug & Solicitações de Recursos](https://github.com/vancedto/vanced-manager-plus/issues)
- **Wiki**: [Documentação](https://github.com/vancedto/vanced-manager-plus/wiki)

---

**RV Manager Plus 3.0** - A próxima geração de ferramentas de gerenciamento de aplicativos. Experimente a diferença que arquitetura de software profissional e design centrado no usuário podem fazer.

*Construído com ❤️ pela comunidade, para a comunidade.* 