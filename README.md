# 🌐 API Corporativa - Sistema Backend RESTful

API desenvolvida em **Java 17** e **Spring Boot 3.3**, estruturada em camadas de mercado e equipada com segurança baseada em tokens (JWT), documentação interativa automatizada e banco de dados em memória.

Este projeto foi evoluído de uma estrutura básica para um ecossistema backend moderno, aplicando padrões de segurança corporativa e facilidade de deploy/execução local.

---

## 🚀 Funcionalidades Atuais

- **CRUD Completo de Usuários:** Cadastro, listagem, atualização e exclusão de registros.
- **Segurança Avançada (Spring Security 3):** Proteção de endpoints privados com arquitetura *Stateless*.
- **Autenticação JWT (JSON Web Token):** Filtros customizados para interceptação e validação de tokens `Bearer`.
- **Banco de Dados em Memória (H2 Database):** Inicialização instantânea do banco direto na memória RAM, eliminando a necessidade de instalações locais complexas.
- **Painel de Monitoramento SQL:** Console web integrado para inspecionar tabelas e dados em tempo real.
- **Documentação Automatizada (Swagger/OpenAPI):** Interface gráfica para testar todos os endpoints direto do navegador.
- **Validação de Dados:** Filtros com `spring-boot-starter-validation` para garantir a integridade dos payloads (DTOs).

---

## 🧠 Tecnologias Utilizadas

- **Java 17** (LTS)
- **Spring Boot 3.3.5**
- **Spring Web** (Construção de rotas REST)
- **Spring Data JPA** (Persistência e ORM)
- **Spring Security** (Controle de acessos)
- **H2 Database** (Banco de Dados em memória)
- **JSON Web Token (JJWT 0.11.5)** (Geração e validação de tokens)
- **Springdoc OpenAPI / Swagger UI** (Documentação da API)
- **Maven** (Gerenciador de dependências e build)

---

## 📁 Estrutura do Projeto

```text
├── src/main/java/com/exemplo/projeto/
│   ├── controller/          # Exposição dos endpoints REST
│   │   └── UsuarioController.java
│   ├── service/             # Regras de negócio da aplicação
│   │   └── UsuarioService.java
│   ├── repository/          # Interface de comunicação com o banco (JPA)
│   │   └── UsuarioRepository.java
│   ├── model/               # Entidades mapeadas para o banco de dados
│   │   └── Usuario.java
│   ├── security/            # Filtros JWT e configurações do Spring Security
│   │   ├── SecurityConfig.java
│   │   └── JwtAuthenticationFilter.java
│   └── ApiApplication.java  # Classe principal (Inicializadora)
│
├── src/main/resources/
│   └── application.properties # Parâmetros do H2, Hibernate e Swagger
│
├── pom.xml                  # Dependências e plugins do Maven
└── README.md                # Documentação do repositório
```

⚙️ Como Executar o Projeto
Você não precisa ter o PostgreSQL ou MySQL instalado. O projeto está configurado para rodar de forma independente.

1. Clonar o repositório

git clone [https://github.com/Boueri/api-java.git](https://github.com/Boueri/api-java.git)
cd api-java

2. Compilar e Rodar a Aplicação
Utilize o Maven Wrapper ou o executável local apontando para a pasta do projeto:

.\apache-maven-3.9.6\bin\mvn clean spring-boot:run

4. Acessar a Documentação (Swagger UI)
Assim que o terminal exibir que o Spring iniciou, abra o navegador e acesse para testar os endpoints:
👉 http://localhost:8080/swagger-ui/index.html

5. Acessar o Banco de Dados (H2 Console)
Para visualizar as tabelas criadas automaticamente pelo Hibernate:
👉 http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:projetodb

User Name: sa

Password: (deixe em branco)

📌 Principais Endpoints
🔓 Rotas Públicas (Livres de Autenticação)
POST /auth/login -> Realiza autenticação e retorna o Token JWT.

GET /swagger-ui/index.html -> Visualização da documentação.

GET /h2-console -> Gerenciador do banco de dados.

🔐 Rotas Protegidas (Requer Token Bearer <TOKEN> no Header)
GET /usuarios -> Listar todos os usuários.

POST /usuarios -> Criar um novo usuário.

PUT /usuarios/{id} -> Atualizar dados do usuário.

DELETE /usuarios/{id} -> Excluir usuário do sistema.

🚀 Próximos Passos (Melhorias Futuras)
[ ] Migração do banco de dados H2 para PostgreSQL/MySQL em ambiente de produção usando Profiles do Spring.

[ ] Implementação de Testes Unitários e de Integração com JUnit 5 e Mockito.

[ ] Conteinerização da aplicação utilizando Docker e Docker Compose.

[ ] Criação de script de migração de banco de dados com Flyway.

👨‍💻 Autor
João Gabriel Boueri Santos

Projeto desenvolvido para consolidar conceitos de Arquitetura Limpa, Segurança em APIs REST e persistência de dados com o ecossistema Spring.
