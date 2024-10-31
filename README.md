# Fitness Tracker App

Um aplicativo Android para monitorar atividades físicas e registrar progresso.

## 📱 Descrição

O Fitness Tracker App é uma ferramenta projetada para ajudar os usuários a monitorar suas atividades físicas, registrar o tempo de exercício e acompanhar o progresso ao longo do tempo. Os usuários podem adicionar diferentes tipos de atividades, como corrida, caminhada e visualizar um histórico de seus treinos.

## 🔧 Funcionalidades

- [x] Registro de atividades físicas (corrida, caminhada)
- [x] Visualização de histórico de exercícios
- [x] Gráficos de progresso ao longo do tempo

 
## 🚀 Tecnologias Utilizadas

- [x] **Android Studio** (Bumblebee | 2024.1.2)
- [x] **Java** para desenvolvimento
- [x] Room para persistência de dados

## 🛠️ Como Rodar o Projeto

Siga os passos abaixo para rodar o projeto localmente:

1. Clone este repositório:
    ```bash
    https://github.com/Cassielbr/AppSport
    ```
2. Abra o projeto no Android Studio.

3. Compile e execute o projeto em um emulador ou dispositivo físico.

## 📂 Estrutura do Projeto
```bash
├── app
│   └── manifests
│      └── AndroidManifest.xml              # Manifesto do aplicativo
│   │   ├── Java
│   │   │   ├── java/br/ulbra/appsport
│   │   │   │   ├── CalcularIMCActivity.java      # Atividade para cálculo de IMC
│   │   │   │   ├── HistoricoActivity.Java         # Atividade para visualizar o histórico
│   │   │   │   ├── MainActivity.java             # Atividade principal do aplicativo
│   │   │   ├── res
│   │   │   │   ├── drawable
│   │   │   │   │   ├── ic_launcher.png           # Ícone do aplicativo
│   │   │   │   │   ├── background_image.png      # Imagem de fundo
│   │   │   │   │   ├── corre.png                  # Imagem de corrida
│   │   │   │   │   ├── corrida.png                # Imagem de corrida (versão alternativa)
│   │   │   │   │   ├── perfil.png                 # Imagem de perfil do usuário
│   │   │   │   │   ├── relogio.png                # Imagem de ícone de relógio
│   │   │   │   │   ├── tela.png                   # Imagem de tela principal
│   │   │   │   │   └── tempo.png                  # Imagem de tempo
│   │   │   │   ├── layout
│   │   │   │   │   ├── activity_calcular_imc.xml   # Layout da tela de cálculo de IMC
│   │   │   │   │   ├── activity_historico.xml       # Layout da tela de histórico
│   │   │   │   │   └── activity_main.xml            # Layout da tela principal
│   │   │   │   └── values
│   │   │   │       ├── strings.xml                  # Strings usadas no app
│   │   │   │       ├── colors.xml                   # Cores definidas no projeto
│   │   │   │       └── styles.xml                   # Estilos do aplicativo
│   └── build.gradle                                    # Configuração do Gradle
└── README.md                                           # Este arquivo

```
# 🖥️ Telas do Aplicativo. 
## Tela Principal
![image](https://github.com/Cassielbr/AppSport/blob/master/assets/principal.png)

## Tela Calcular
![image](https://github.com/Cassielbr/AppSport/blob/master/assets/Calcular.png)

## Tela Histórico
![image](https://github.com/Cassielbr/AppSport/blob/master/assets/historico.png)


## 👨‍💻 Desenvolvedores – 
**Cassiel** - Desenvolvedor - [GitHub](https://github.com/Cassielbr)

## 📄 Licença 
Este projeto está licenciado sob os termos da licença MIT. Para mais detalhes, veja o arquivo [LICENSE](https://github.com/Cassielbr/AppSport/blob/master/LICENSE).
