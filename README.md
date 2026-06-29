# 🚀 API REST - Spring Boot

API REST desenvolvida com Spring Boot para gerenciamento de dados com autenticação JWT, persistência em banco de dados e documentação via Swagger.

Este projeto foi criado com foco em boas práticas de desenvolvimento backend, segurança e arquitetura em camadas, simulando um ambiente real de produção.

---

## 🧠 Objetivo do Projeto

O objetivo desta API é demonstrar a construção de um backend completo utilizando Java + Spring Boot, incluindo:

- Autenticação e autorização com JWT
- CRUD completo de recursos
- Integração com banco de dados relacional
- Documentação automática da API
- Estrutura organizada em camadas (Controller, Service, Repository)

---

## ⚙️ Tecnologias Utilizadas

- ☕ Java 17+
- 🌱 Spring Boot
- 🔐 Spring Security + JWT
- 🗄️ Spring Data JPA
- 🐘 Banco de dados (MySQL / PostgreSQL)
- 📄 Swagger / OpenAPI
- 🧪 Maven

---

## 🏗️ Arquitetura do Projeto

O projeto segue arquitetura em camadas:
controller → service → repository → database


### 📦 Estrutura de pacotes:
``` 
src
  controller
  service
  repository
  model
  dto
  security
  config
  exception
```
---

## 🔐 Autenticação (JWT)

A API utiliza autenticação baseada em token JWT.

### Fluxo:

1. Usuário realiza login
2. API retorna token JWT
3. Token é enviado no header das requisições protegidas:

```

Authorization: Bearer YOUR\_TOKEN

📡 Endpoints principais
🔑 Auth
POST /auth/login → Autentica usuário e retorna JWT
POST /auth/register → Cria novo usuário
👤 Usuários
GET /users → Lista usuários
GET /users/{id} → Busca usuário por ID
POST /users → Cria usuário
PUT /users/{id} → Atualiza usuário
DELETE /users/{id} → Remove usuário
📄 Documentação (Swagger)
```

A documentação da API está disponível via Swagger:


http://localhost:8080/swagger-ui.html

🗄️ Banco de Dados

Configuração realizada via application.properties.

Exemplo:


spring.datasource.url=jdbc:mysql://localhost:3306/nome\_db
spring.datasource.username=root
spring.datasource.password=senha


🚀 Como executar o projeto

1. Clonar o repositório
git clone https://github.com/Boueri/api-rest-springboot.git

3. Entrar no diretório
cd api-rest-springboot

4. Configurar banco de dados

Editar application.properties

5. Rodar aplicação
mvn spring-boot:run


🐳 (Opcional) Rodando com Container (Podman)
Build da imagem:
podman build -t api-springboot .
Executar container:
podman run -p 8080:8080 api-springboot


Logs estruturados
👨‍💻 Autor

Desenvolvido por Bou

GitHub: https://github.com/Boueri

LinkedIn: www.linkedin.com/in/joao-gabriel-boueri
