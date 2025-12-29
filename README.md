# 🔗 ConnectPro – Plataforma Profissional

> Plataforma backend desenvolvida em **Spring Boot**, inspirada no LinkedIn, focada em **networking profissional**, **perfis**, **postagens**, **interações sociais** e **segurança**.

> Projeto **para fins educacionais e de portfólio**, demonstrando boas práticas de **arquitetura REST**, **Spring Security + JWT**, **organização em camadas** e **documentação com Swagger**.

---

## 📑 Conteúdo

* [Visão geral do projeto](#visão-geral-do-projeto)
* [Tecnologias utilizadas](#tecnologias-utilizadas)
* [Estrutura do projeto](#estrutura-do-projeto)
* [Funcionalidades](#funcionalidades)
* [Endpoints principais](#endpoints-principais)
* [Como executar o projeto](#como-executar-o-projeto)
* [Contribuidores](#Contribuidores)

---

## 📌 Visão geral do projeto

O **ConnectPro** é uma **API RESTful** desenvolvida em **Java com Spring Boot**, inspirada em plataformas profissionais como o LinkedIn.

O sistema permite:
- Criação de **perfis profissionais**
- **Conexões** entre usuários
- **Publicações**, curtidas e comentários
- **Autenticação segura** com JWT

O projeto segue boas práticas como **separação de camadas**, **DTOs**, **tratamento global de exceções** e **segurança robusta**.

---

## 🚀 Funcionalidades

### 👤 Usuários & Perfis
- Cadastro de usuário
- Login com autenticação JWT
- Atualização de perfil profissional
- Cargo, empresa, bio e habilidades
- Upload de foto de perfil

### 🤝 Conexões
- Enviar solicitação de conexão
- Aceitar ou recusar conexões
- Listar conexões do usuário

### 📝 Publicações
- Criar postagens
- Feed de postagens
- Curtir e descurtir postagens
- Comentar em postagens

### 🔔 Interações
- Curtidas
- Comentários
- Feed personalizado baseado nas conexões

### 🔐 Segurança
- Spring Security + JWT
- Controle de acesso por usuário
- Senhas criptografadas com BCrypt

---

## 🧱 Arquitetura do projeto

Estrutura baseada em **MVC + API REST**:


---

## 🗄️ Banco de dados

Banco de dados relacional com **JPA/Hibernate**.

### Principais tabelas:
- users
- profiles
- posts
- comments
- likes
- connections

Compatível com:
- PostgreSQL
- MySQL

---

## 🛠️ Tecnologias utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- JWT (JSON Web Token)
- Hibernate
- PostgreSQL / MySQL
- Maven
- Lombok
- Swagger / OpenAPI 3

---

## 📡 Endpoints principais (exemplos)

### 🔐 Autenticação
| Método | Endpoint |
|------|---------|
| POST | /auth/register |
| POST | /auth/login |

### 👤 Usuários
| Método | Endpoint |
|------|---------|
| GET | /users/{id} |
| PUT | /users/{id} |

### 🤝 Conexões
| Método | Endpoint |
|------|---------|
| POST | /connections/{id} |
| GET | /connections |

### 📝 Publicações
| Método | Endpoint |
|------|---------|
| POST | /posts |
| GET | /posts/feed |
| POST | /posts/{id}/like |
| POST | /posts/{id}/comment |

---

## ▶️ Como executar o projeto

### Pré-requisitos
- Java 17+
- Maven
- PostgreSQL ou MySQL configurado

### Executando localmente

bash
git clone https://github.com/seu-usuario/connectpro.git
cd connectpro
mvn spring-boot:run

## 💬 Comunidade e Suporte

Junte-se às nossas discussões da comunidade no GitHub para compartilhar ideias, fazer perguntas ou sugerir melhorias. Vamos construir algo incrível juntos!

[![Abrir Issues](https://img.shields.io/badge/Abrir%20Issues-blue?style=for-the-badge&logo=github)](https://github.com/FilipeHSAraujo/ConnectPro/issues)

Use o espaço de *issues* para relatar bugs, sugerir melhorias ou tirar dúvidas sobre o projeto 💬

---

## 👥 Contribuidores

Agradecimento especial a todas as pessoas incríveis que contribuíram para este projeto 💙

<a href="https://github.com/FilipeHSAraujo/ConnectPro/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=FilipeHSAraujo/ConnectPro" />
</a>



## 📄 Licença

Este projeto é open-source e está disponível sob a Licença MIT. Sinta-se livre para usar, modificar e distribuir para projetos pessoais ou comerciais.



