# 📚 Book Store REST API

## Description

**Book Store REST API** is a RESTful backend application for managing a bookstore system.  
The project is built using **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **PostgreSQL**.

The application provides **CRUD operations** for books and related entities such as authors, categories, formats, publishers, orders, and payments.

---

## Architecture

The project follows a **layered architecture**:

- **Controller layer** – REST endpoints
- **Service layer** – business logic
- **Repository layer** – database access (JPA)
- **DTO + Mapper layer** – data transfer and mapping
- **Test layer** – unit testing

---

## Technologies Used

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL**
- **MapStruct**
- **Lombok**
- **JUnit 5**
- **Mockito**
- **Gradle**

---

## Project Structure

```text
src/main/java/com/example/demo
│
├── controller        # REST controllers
├── service
│   └── impl          # Service implementations
├── repository        # JPA repositories
├── entity            # JPA entities
├── dto
│   ├── request       # Request DTOs
│   └── response      # Response DTOs
├── mapper            # MapStruct mappers
└── config            # Configuration classes
