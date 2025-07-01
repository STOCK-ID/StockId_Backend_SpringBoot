# StockId - Backend Spring Boot

Este repositório contém a aplicação **backend** do sistema **StockId**, um projeto voltado ao controle de estoque e vendas para **pequenos comércios** — com foco em **usabilidade para usuários analfabetos ou semianalfabetos digitais**.

---

## ✨ Objetivo do Projeto

O StockId tem como missão oferecer um sistema simples, intuitivo e acessível para gerenciar estoques, registrar vendas e organizar produtos em **comercios de bairro**, pensando especialmente em pessoas com **baixo letramento digital**.

---

## 🔧 Tecnologias Utilizadas

- **Java 22**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **H2 Database (para testes)**
- **Swagger/OpenAPI** (documentação da API)
- **Lombok**
- **Maven**

---

## 📁 Estrutura do Projeto

```bash
src/
├── configs/   # Configurações iniciais, CORS, segurança, seed de dados
├── controller/       # Camada de controladores REST
├── enums/            # Enums usados no sistema
├── exception/        # Tratamento de exceções personalizadas
├── model/            # Entidades JPA
├──── DTO/            # Data Transfer Objects
├──── WriteDTO/       # Data Transfer Objects (Inserção)
├── repository/       # Interfaces do Spring Data JPA
└── services/         # Regras de negócio
```
---

## 🚀 Como Executar o Projeto Localmente

### Pré-requisitos

- Java 22+
- Maven

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/STOCK-ID/StockId_Backend_SpringBoot.git

   cd StockId_Backend_SpringBoot

2. Configure as credencias do Banco de Dados no application.properties:

    ```bash
    spring.datasource.url=jdbc:h2:mem:stockid
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=joao
    spring.datasource.password=1234

3. Tenha certeza de que você está na pasta onde está o arquivo pom.xml e então execute o comando:

    ```bash
    mvn spring-boot:run

4. Para testar a API e acessar sua documentação, utilize:

    ```bash
    http://localhost:8080/swagger-ui/index.html

---

## 💡 Foco em Acessibilidade
- O projeto se destaca por incluir recursos como:

- Integração futura com comandos de voz para navegação

- Utilização de ícones, imagens e vídeos tutoriais para facilitar o uso

- Interface amigável pensada para uso com pouco ou nenhum texto

- Inclusão planejada de leitura de código de barras por câmera

---
## 👨‍💻 Autor
Projeto desenvolvido por João Felipe Santana de Freitas como parte de um projeto para facilitar o acesso à tecnologia em comunidades vulneráveis.