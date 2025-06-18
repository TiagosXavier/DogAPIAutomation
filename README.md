
# Dog API Automation Tests

Este projeto contém testes automatizados para a [Dog API](https://dog.ceo/dog-api/), desenvolvidos com **Java**, **Maven**, **JUnit 5** e **Rest Assured**. O objetivo é validar o comportamento dos principais endpoints da API relacionados a raças de cachorros e suas imagens, garantindo a qualidade e a confiabilidade da integração.

----------

## 🚀 Tecnologias Utilizadas

-   **Java 11+**: Linguagem de programação.
-   **Apache Maven**: Ferramenta de automação de build e gerenciamento de dependências.
-   **JUnit 5**: Framework de testes para Java.
-   **Rest Assured**: Biblioteca Java para testar serviços REST.
-   **Hamcrest**: Biblioteca para criação de matchers flexíveis e legíveis (utilizada com Rest Assured).
-   **Allure Framework**: Ferramenta flexível e leve para gerar relatórios de execução de testes.

----------

## 🛠️ Pré-requisitos

Para rodar este projeto na sua máquina, você precisará ter instalado:

-   **Java Development Kit (JDK) 11 ou superior**
-   **Apache Maven 3.6.0 ou superior**
-   **Git** 
-   **Allure Commandline**: Ferramenta de linha de comando do Allure para gerar relatórios.

### Configuração do Apache Maven no seu PC

1.  **Baixe o Maven**: Vá para o site oficial do Apache Maven ([https://maven.apache.org/download.cgi](https://maven.apache.org/download.cgi)) e baixe a versão mais recente (o arquivo binário, `apache-maven-X.Y.Z-bin.zip` ou `.tar.gz`).
2.  **Descompacte o Maven**: Descompacte o arquivo baixado em um diretório de sua preferência (ex: `C:\Program Files\Apache\apache-maven-X.Y.Z` no Windows ou `/opt/apache-maven-X.Y.Z` no Linux/macOS).
3.  **Configure Variáveis de Ambiente**:
    -   **Windows**:
        -   Clique com o botão direito em "Este Computador" ou "Meu Computador" > "Propriedades" > "Configurações avançadas do sistema" > "Variáveis de Ambiente".
        -   Em "Variáveis do sistema", clique em "Novo..." e crie:

            -   **Nome da variável**: `M2_HOME`
            -   **Valor da variável**: Caminho onde você descompactou o Maven (ex: `C:\Program Files\Apache\apache-maven-X.Y.Z`)
        -   Em "Variáveis do sistema", edite a variável `Path`:
            -   Adicione uma nova entrada: `%M2_HOME%\bin`
        -   Crie ou edite a variável `JAVA_HOME` para apontar para a sua instalação do JDK (ex: `C:\Program Files\Java\jdk-11.0.x`).
    -   **Linux/macOS**:
        -   Abra seu arquivo de perfil de shell (ex: `~/.bashrc`, `~/.zshrc` ou `~/.profile`).
        -   Adicione as seguintes linhas (ajustando os caminhos):

            Bash

            ```
            export JAVA_HOME=/caminho/para/o/seu/jdk-11
            export M2_HOME=/caminho/para/o/seu/apache-maven-X.Y.Z
            export PATH=$PATH:$M2_HOME/bin
            
            ```

        -   Salve o arquivo e execute `source ~/.bashrc` (ou o nome do seu arquivo) para aplicar as mudanças.
4.  **Verifique a Instalação**: Abra um novo terminal/prompt de comando e execute:

    Bash

    ```
    mvn -v
    
    ```

    Você deverá ver a versão do Maven e do Java instaladas.

### Instalação do Allure Commandline

1.  **Baixe o Allure**: Vá para a página de releases do Allure ([https://github.com/allure-framework/allure2/releases](https://github.com/allure-framework/allure2/releases)) e baixe a versão mais recente do `allure-X.Y.Z.zip` ou `allure-X.Y.Z.tgz`.
2.  **Descompacte**: Descompacte o arquivo em um diretório de sua escolha (ex: `C:\Program Files\Allure` ou `/opt/allure-X.Y.Z`).
3.  **Configure a variável de ambiente `PATH`**: Adicione o caminho para a pasta `bin` do Allure à sua variável de ambiente `PATH` (seguindo os passos similares aos do Maven para Windows ou Linux/macOS).
4.  **Verifique a Instalação**: Abra um novo terminal/prompt de comando e execute:

    Bash

    ```
    allure --version
    
    ```

    Você deverá ver a versão do Allure instalada.

----------

## 📦 Como Configurar e Rodar os Testes

Siga os passos abaixo para configurar e executar os testes.

### 1. Clonar o Repositório 

Abra seu terminal ou prompt de comando e execute:

Bash

```
git clone https://github.com/TiagosXavier/DogAPIAutomation.git
cd DogAPIAutomation

```

### 2. Adicionar Dependências do Allure no `pom.xml`

Abra o arquivo `pom.xml` na raiz do seu projeto e adicione as seguintes dependências e build plugins dentro da tag `<project>` (geralmente dentro de `<build>` e `<properties>`):

XML

```
 <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.jupiter.version>5.10.0</junit.jupiter.version> <rest-assured.version>5.3.0</rest-assured.version>
        <allure.version>2.24.0</allure.version> <allure.maven.version>2.12.0</allure.maven.version> <maven.surefire.plugin.version>3.2.5</maven.surefire.plugin.version> <maven.compiler.plugin.version>3.13.0</maven.compiler.plugin.version> <aspectj.version>1.9.21</aspectj.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>${rest-assured.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>${junit.jupiter.version}</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>${junit.jupiter.version}</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-junit5</artifactId>
            <version>2.23.0</version>
            <scope>test</scope>
        </dependency>

    </dependencies>

    <build>
        <plugins>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0</version>
                <configuration>
                    <properties>
                        <property>
                            <name>listener</name>
                            <value>io.qameta.allure.junitplatform.AllureJunitPlatform</value>
                        </property>
                    </properties>
                    <systemPropertyVariables>
                        <allure.results.directory>target/allure-results</allure.results.directory>
                    </systemPropertyVariables>
                </configuration>
            </plugin>

            <plugin>
                <groupId>io.qameta.allure</groupId>
                <artifactId>allure-maven</artifactId>
                <version>2.15.2</version>
            </plugin>

        </plugins>
    </build>

```

-   **Nota**: Certifique-se de verificar as versões mais recentes das dependências do Allure (`allure.version`, `allure.maven.version`, `aspectj.version`) no [Maven Central](https://search.maven.org/) para garantir que você está usando as versões mais atualizadas.

### 3. Importar o Projeto na IDE (Opcional, mas Recomendado)

Se você estiver usando uma IDE como IntelliJ IDEA, Eclipse ou VS Code, importe o projeto como um projeto Maven existente. A IDE deve detectar o `pom.xml` e gerenciar as dependências automaticamente.

### 4. Baixar Dependências

Navegue até o diretório raiz do projeto (`DogAPIAutomation`) no seu terminal e execute o comando Maven para baixar todas as dependências necessárias e compilar o projeto:

Bash

```
mvn clean install

```

### 5. Executar os Testes (Gerando Dados para o Allure)

Você pode executar os testes de duas maneiras:

#### a) Via IDE

Abra a classe de testes `BreedTests.java` (localizada em `src/test/java/com/seuprojeto/dogapi/tests/`) na sua IDE. Clique no ícone de "play" (executar) ao lado da declaração da classe ou dos métodos de teste individuais para executá-los. _Para gerar os dados do Allure, você precisará usar o Maven, mesmo que execute pela IDE._

#### b) Via Linha de Comando (Recomendado para Allure)

No terminal, estando no diretório raiz do projeto (`DogAPIAutomation`), execute:

Bash

```
mvn clean test

```

Este comando executará todos os testes e gerará os arquivos de resultados do Allure na pasta `target/allure-results`.

### 📊 Visualizar Relatórios de Teste Allure

Após a execução dos testes via linha de comando (`mvn clean test`), os resultados brutos do Allure são gerados. Para visualizá-los como um relatório HTML interativo, siga estes passos:

1.  **Gerar o Relatório Allure**: Certifique-se de que o **Allure Commandline** está instalado e configurado no seu `PATH` (como descrito na seção "Pré-requisitos"). Navegue até o diretório raiz do seu projeto no terminal e execute:

    Bash

    ```
    allure serve target/allure-results
    
    ```

    Este comando irá:

    -   Processar os arquivos de resultados do Allure (`target/allure-results`).
    -   Gerar o relatório HTML completo em uma pasta temporária.
    -   Abrir automaticamente o relatório no seu navegador padrão.

    Alternativamente, você pode gerar o relatório sem abri-lo automaticamente, salvando-o em uma pasta específica:

    Bash

    ```
    allure generate target/allure-results --output target/allure-report --clean
    
    ```

    Depois de gerar, você pode abrir o relatório HTML manualmente:

    Bash

    ```
    allure open target/allure-report
    ```