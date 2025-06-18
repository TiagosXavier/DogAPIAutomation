# Dog API Automation Tests

Este projeto contém testes automatizados para a [Dog API](https://dog.ceo/dog-api/), desenvolvidos com **Java**, **Maven**, **JUnit 5** e **Rest Assured**. O objetivo é validar o comportamento dos principais endpoints da API relacionados a raças de cachorros e suas imagens, garantindo a qualidade e a confiabilidade da integração.

----------

## 🚀 Tecnologias Utilizadas

-   **Java 11+**: Linguagem de programação.
-   **Apache Maven**: Ferramenta de automação de build e gerenciamento de dependências.
-   **JUnit 5**: Framework de testes para Java.
-   **Rest Assured**: Biblioteca Java para testar serviços REST.
-   **Hamcrest**: Biblioteca para criação de matchers flexíveis e legíveis (utilizada com Rest Assured).

----------

## 🛠️ Pré-requisitos

Para rodar este projeto na sua máquina, você precisará ter instalado:

-   **Java Development Kit (JDK) 11 ou superior**
-   **Apache Maven 3.6.0 ou superior**
-   **Git** (opcional, se for clonar o repositório)

----------

## 📦 Como Configurar e Rodar os Testes

Siga os passos abaixo para configurar e executar os testes.

### 1. Clonar o Repositório (se aplicável)

Abra seu terminal ou prompt de comando e execute:

```
git clone <URL_DO_SEU_REPOSITORIO>
cd DogAPIAutomation

```

### 2. Importar o Projeto na IDE (Opcional, mas Recomendado)

Se você estiver usando uma IDE como IntelliJ IDEA, Eclipse ou VS Code, importe o projeto como um projeto Maven existente. A IDE deve detectar o pom.xml e gerenciar as dependências automaticamente.

### 3. Baixar Dependências

Navegue até o diretório raiz do projeto (DogAPIAutomation) no seu terminal e execute o comando Maven para baixar todas as dependências necessárias e compilar o projeto:

```
mvn clean install

```

### 4. Executar os Testes

Você pode executar os testes de duas maneiras:

#### a) Via IDE

Abra a classe de testes BreedTests.java (localizada em src/test/java/com/seuprojeto/dogapi/tests/) na sua IDE. Clique no ícone de "play" (executar) ao lado da declaração da classe ou dos métodos de teste individuais para executá-los.

#### b) Via Linha de Comando

No terminal, estando no diretório raiz do projeto (DogAPIAutomation), execute:

```
mvn clean test

```

Este comando executará todos os testes e gerará os relatórios.

### 📊 Visualizar Relatórios de Teste

Após a execução dos testes via linha de comando (mvn clean test), os relatórios detalhados serão gerados.

1.  Navegue até a pasta target/surefire-reports/ no seu projeto.
2.  Abra o arquivo surefire-report.html no seu navegador web.

Este relatório HTML fornecerá um resumo claro e detalhado dos resultados dos testes, incluindo quais testes passaram, quais falharam e, em caso de falha, a mensagem de erro e o stack trace correspondente.
