🚀 VERSÃO MELHORADA (pronta pra GitHub)

Aqui está sua versão nivelada como portfólio profissional:

# 🚀 API REST - Spring Boot

API REST desenvolvida com Spring Boot para gerenciamento de dados com autenticação JWT, persistência em banco de dados e documentação via Swagger.

O projeto simula um ambiente real de produção, aplicando boas práticas de arquitetura backend.

---

## 🧠 Objetivo do Projeto

Construir uma API completa utilizando Java + Spring Boot com foco em:

- Autenticação e autorização com JWT  
- CRUD completo de recursos  
- Integração com banco de dados relacional  
- Documentação automática com Swagger  
- Arquitetura em camadas (Controller, Service, Repository)

---

## ⚙️ Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- MySQL / PostgreSQL
- Swagger / OpenAPI
- Maven

---

## 🏗️ Arquitetura do Projeto

A aplicação segue arquitetura em camadas:


controller → service → repository → database


### 📦 Estrutura de pacotes


src
controller
service
repository
model
dto
security
config
exception


---

## 🔐 Autenticação (JWT)

A API utiliza autenticação baseada em token JWT.

### Fluxo de autenticação:

1. Usuário realiza login
2. API gera token JWT
3. Token é enviado nas requisições protegidas

### Exemplo de header:


Authorization: Bearer YOUR_TOKEN


---

## 📡 Endpoints principais

### 🔑 Auth

```http
POST /auth/login
POST /auth/register
👤 Usuários
GET    /users
GET    /users/{id}
POST   /users
PUT    /users/{id}
DELETE /users/{id}
📄 Documentação (Swagger)
```


A documentação da API pode ser acessada em:

http://localhost:8080/swagger-ui.html
🗄️ Banco de Dados

Configuração via application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/nome_db
spring.datasource.username=root
spring.datasource.password=senha
🚀 Como executar o projeto
1. Clonar repositório
git clone https://github.com/Boueri/api-rest-springboot.git
2. Entrar no projeto
cd api-rest-springboot
3. Configurar banco de dados

Editar application.properties

4. Rodar aplicação
mvn spring-boot:run
🐳 Rodando com Podman
Build da imagem
podman build -t api-springboot .
Executar container
podman run -p 8080:8080 api-springboot


👨‍💻 Autor

Desenvolvido por Bou

GitHub: https://github.com/Boueri

LinkedIn: www.linkedin.com/in/joao-gabriel-boueri
