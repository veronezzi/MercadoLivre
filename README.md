<h1>📱 Visão Geral</h1>

<p>Este projeto é um clone simplificado do aplicativo <strong>Mercado Livre</strong>, desenvolvido para Android utilizando:</p>

<ul>
  <li>🟨 <strong>Kotlin</strong> como linguagem principal</li>
  <li>🧱 <strong>Jetpack Compose</strong> para UI moderna</li>
  <li>🧠 <strong>Arquitetura MVVM</strong> (Model-View-ViewModel)</li>
  <li>💉 <strong>Injeção de dependência com Koin</strong></li>
  <li>🧭 <strong>Navegação com Navigation Component</strong></li>
  <li>🌐 <strong>Consumo de API com Retrofit</strong></li>
</ul>

<hr />

<h2>🛠️ Funcionalidades Principais</h2>

<ul>
  <li>🔍 Tela de busca de produtos</li>
  <li>📋 Listagem de resultados</li>
  <li>🖼️ Visualização de detalhes do produto</li>
  <li>🔄 Gestão de estados: <code>loading</code>, <code>error</code> e <code>success</code></li>
  <li>🔙 Navegação entre telas</li>
</ul>

<hr />

<h2>🏗️ Arquitetura do Projeto</h2>

<pre><code>📦 com.example.mercadolivre
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
</code></pre>

<hr />

<h2>🚀 Como Executar</h2>

<ol>
  <li>Clone o repositório:</li>
</ol>

<pre><code>git clone https://github.com/veronezzi/MercadoLivre.git</code></pre>

<ol start="2">
  <li>Abra o projeto no <strong>Android Studio</strong> (versão recomendada: <em>Electric Eel</em> ou superior)</li>
  <li>Execute o app em um <strong>emulador</strong> ou <strong>dispositivo Android físico</strong></li>
</ol>

<hr />

<h2>📚 Bibliotecas Utilizadas</h2>

<table>
  <thead>
    <tr>
      <th>Biblioteca</th>
      <th>Função</th>
    </tr>
  </thead>
  <tbody>
    <tr><td>Jetpack Compose</td><td>UI declarativa moderna</td></tr>
    <tr><td>Retrofit</td><td>Cliente HTTP para APIs</td></tr>
    <tr><td>Koin</td><td>Injeção de dependência</td></tr>
    <tr><td>Coil</td><td>Carregamento eficiente de imagens</td></tr>
    <tr><td>Navigation Component</td><td>Navegação entre telas</td></tr>
    <tr><td>Kotlin Coroutines</td><td>Programação assíncrona</td></tr>
  </tbody>
</table>

<hr />

<h2>📸 Capturas de Tela</h2>

<p align="center">
  <img src="https://github.com/user-attachments/assets/93c1c3b6-2a2f-4356-85bd-26243daa4345" width="30%" style="margin-right: 10px;" />
  <img src="https://github.com/user-attachments/assets/73b80b8d-ae7a-4b5c-8266-d2526e1d1ee8" width="30%" style="margin-right: 10px;" />
  <img src="https://github.com/user-attachments/assets/5c82b047-2d39-4a14-8c63-d19676d40d25" width="30%" />
</p>

<hr />

<h2>📝 Licença</h2>

<p>Este projeto está licenciado sob a <strong>Licença MIT</strong>.<br />
Consulte o arquivo <code>LICENSE</code> para mais detalhes.</p>

<hr />

<h2>🤝 Comentários</h2>

<p>As APIs foram <strong>mocadas</strong> devido ao erro de autenticação <code>401</code>, onde todas as requisições exigem um <strong>token</strong> que, mesmo sendo enviado corretamente, <strong>não são autorizadas</strong>.</p>
