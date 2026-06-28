# 🌐 API Java - Sistema Backend

API desenvolvida em Java para gerenciamento de dados com arquitetura em camadas e exposição de endpoints REST.

Este projeto tem como objetivo praticar desenvolvimento backend, organização de código e boas práticas de API.

---

## 🚀 Funcionalidades

- CRUD completo (Create, Read, Update, Delete)
- Criação de endpoints REST
- Validação de dados
- Estrutura em camadas (Controller, Service, Repository)
- Manipulação de JSON
- Regras de negócio organizadas

---

## 🧠 Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Maven
- REST API
- JSON
- JPA (opcional)

---

## 📁 Estrutura do projeto


## 📁 Estrutura do projeto

- src/main/java/com/exemplo/api/
  - controller/
    - UsuarioController.java
  - service/
    - UsuarioService.java
  - repository/
    - UsuarioRepository.java
  - model/
    - Usuario.java
  - ApiApplication.java

- src/main/resources/
  - application.properties

- docs/
  - endpoints.png
  - request.png
  - response.png

- pom.xml
- README.md
- .gitignore

---

## ⚙️ Como executar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/Boueri/api-java.git
2. Entrar na pasta
cd api-java
3. Instalar dependências
mvn clean install
4. Rodar a aplicação
mvn spring-boot:run
5. Acessar API
http://localhost:8080
📌 Exemplos de endpoints
🔹 Criar usuário

POST /usuarios

{
  "nome": "João",
  "email": "joao@email.com"
}
🔹 Listar usuários

GET /usuarios

[
  {
    "id": 1,
    "nome": "João",
    "email": "joao@email.com"
  }
]
🔹 Atualizar usuário

PUT /usuarios/{id}

{
  "nome": "João Atualizado",
  "email": "novo@email.com"
}
🔹 Deletar usuário

DELETE /usuarios/{id}

🔐 Melhorias futuras
Autenticação JWT
Spring Security
Banco de dados MySQL/PostgreSQL
Swagger (documentação automática)
Docker
Deploy em nuvem
Testes unitários (JUnit)
📊 Objetivo do projeto

Este projeto foi desenvolvido para praticar:

Desenvolvimento backend com Java
Criação de APIs REST
Arquitetura em camadas
Integração com banco de dados
Boas práticas de programação

👨‍💻 Autor
João Gabriel Boueri Santos
