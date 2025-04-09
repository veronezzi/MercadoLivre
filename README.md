📱 Visão Geral

Este projeto é um clone simplificado do aplicativo Mercado Livre, desenvolvido para Android utilizando:

🟨 Kotlin como linguagem principal
🧱 Jetpack Compose para UI moderna
🧠 Arquitetura MVVM (Model-View-ViewModel)
💉 Injeção de Dependência com Koin
🧭 Navegação com Navigation Component
🌐 Consumo de API com Retrofit
🛠️ Funcionalidades Principais

🔍 Tela de busca de produtos
📋 Listagem de resultados
🖼️ Visualização de detalhes do produto
🔄 Gestão de estados: loading, error e success
🔙 Navegação entre telas

🏗️ Arquitetura do Projeto

📦 com.example.mercadolivre
├── 📂 data
│   ├── 📂 model        # Modelos de dados
│   └── 📂 network      # Configurações de rede
├── 📂 di               # Injeção de dependência (Koin)
├── 📂 presentation
│   ├── 📂 components   # Componentes UI reutilizáveis
│   ├── 📂 navigation   # Navegação entre telas
│   ├── 📂 screens      # Telas principais
│   └── 📂 viewmodel    # Lógica de ViewModels
├── 📂 utils            # Funções utilitárias e extensões
└── 📂 domain           # Lógica de negócios (casos de uso)


🚀 Como Executar

Clone o repositório:
git clone https://github.com/veronezzi/MercadoLivre.git

Abra o projeto no Android Studio (recomendado: versão Electric Eel ou superior)
Execute o app em um emulador ou dispositivo físico Android

📚 Bibliotecas Utilizadas

Biblioteca	Função
Jetpack Compose	UI declarativa moderna
Retrofit	Cliente HTTP para APIs
Koin	Injeção de dependência
Coil	Carregamento eficiente de imagens
Navigation Component	Navegação entre telas
Kotlin Coroutines	Programação assíncrona

<p align="center">
  <img src="https://github.com/user-attachments/assets/93c1c3b6-2a2f-4356-85bd-26243daa4345" width="30%" />
  <img src="https://github.com/user-attachments/assets/73b80b8d-ae7a-4b5c-8266-d2526e1d1ee8" width="30%" />
  <img src="https://github.com/user-attachments/assets/5c82b047-2d39-4a14-8c63-d19676d40d25" width="30%" />
</p>




📝 Licença

Este projeto está licenciado sob a Licença MIT.
Consulte o arquivo LICENSE para mais detalhes.

🤝 Comentários

As APIs foram mocadas devido ao erro de autenticação 401, onde todas as requisições exigem um token que, mesmo sendo enviado corretamente, não são autorizadas.



