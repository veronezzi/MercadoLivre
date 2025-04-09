📱 Visão Geral

Este projeto é um clone simplificado do aplicativo Mercado Livre, desenvolvido para Android utilizando:

Kotlin como linguagem principal
Jetpack Compose para a UI moderna
Arquitetura MVVM (Model-View-ViewModel)
Injeção de Dependência com Koin
Navegação com Navigation Component
Consumo de API com Retrofit
🛠️ Funcionalidades Principais

🔍 Tela de busca de produtos
📋 Listagem de resultados
🖼️ Visualização de detalhes do produto
🔄 Gestão de estados (loading, error, success)
🔙 Navegação entre telas
🏗️ Arquitetura

Copy
📦 com.example.mercadolivre
├── 📂 data
│   ├── 📂 model      # Modelos de dados
│   └── 📂 network    # Configurações de rede
├── 📂 di             # Injeção de dependência
├── 📂 presentation
│   ├── 📂 components # Componentes UI reutilizáveis
│   ├── 📂 navigation # Navegação
│   ├── 📂 screens    # Telas do app
│   └── 📂 viewmodel  # ViewModels
├── 📂 utils          # Utilitários e extensões
└── 📂 domain         # Lógica de negócios
🚀 Como Executar

Clone o repositório:
bash
Copy
git clone https://github.com/veronezzi/MercadoLivre.git
Abra o projeto no Android Studio (versão recomendada: Electric Eel ou superior)
Execute o app em um emulador ou dispositivo Android
📚 Bibliotecas Utilizadas

Biblioteca	Função
Jetpack Compose	UI declarativa
Retrofit	Cliente HTTP
Koin	Injeção de dependência
Coil	Carregamento de imagens
Navigation Component	Navegação entre telas
Kotlin Coroutines	Programação assíncrona
📸 Capturas de Tela

![image](https://github.com/user-attachments/assets/93c1c3b6-2a2f-4356-85bd-26243daa4345)
![image](https://github.com/user-attachments/assets/73b80b8d-ae7a-4b5c-8266-d2526e1d1ee8)
![image](https://github.com/user-attachments/assets/5c82b047-2d39-4a14-8c63-d19676d40d25)




📝 Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo LICENSE para detalhes.

🤝 Comentarios

Api`s foram mocadas devido ao erro 401 de autenticacao onde todas as apis estao requisitando o token, e mesmo assim nao as autorizam
