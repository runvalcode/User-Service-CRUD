---

# User-Service-CRUD

A comprehensive User Management microservice built with Spring Boot, featuring full CRUD operations, global exception handling with @ControllerAdvice, Swagger/OpenAPI documentation, and H2 in-memory database for seamless development and testing.

## 📋 Overview

User-Service-CRUD is a production-ready microservice that provides complete user management capabilities through a well-structured REST API. Built with Spring Boot's robust ecosystem, this service demonstrates best practices in modern microservice development including clean architecture, comprehensive error handling, and automated API documentation.

## ✨ Features

- **Full CRUD Operations**: Complete Create, Read, Update, and Delete functionality for user management
- **RESTful Architecture**: Well-designed REST endpoints following HTTP best practices
- **Global Exception Handling**: Centralized error management using `@ControllerAdvice` for consistent error responses
- **API Documentation**: Auto-generated Swagger/OpenAPI documentation for easy API exploration and testing
- **H2 In-Memory Database**: Embedded database for rapid development, testing, and seamless CI/CD integration
- **Request/Response DTOs**: Clean separation between API contracts and entity models
- **Clean Code**: Well-structured code following SOLID principles

## 🛠️ Technology Stack

- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
- Swagger/OpenAPI
- Maven

## 🚀 Getting Started

### Prerequisites

- JDK 17 or higher
- Maven 3.9+
- Git (optional)

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone <your-repository-url>
   cd User-Service-CRUD
   ```

2. **Build the application**
   ```bash
   mvn clean install
   ```

3. **Run the application**
   ```bash
   mvn spring-boot:run
   ```

4. **Access the application**
   - Application: `http://localhost:8080`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`
   - H2 Console: `http://localhost:8080/h2-console`

## 📚 API Documentation

Once the application is running, access the Swagger UI for interactive API documentation:
- **Swagger UI**: `http://localhost:8080/swagger-ui.html`
- **OpenAPI Spec**: `http://localhost:8080/v3/api-docs`

## 🔌 API Endpoints

Based on your `UserController` implementation:

| Method | Endpoint | Description | Request Body | Response |
|--------|----------|-------------|--------------|----------|
| **POST** | `/api/v1/users` | Create a new user | `UserRequest` | `UserResponse` with 201 Created |
| **GET** | `/api/v1/users` | Retrieve all users | - | List of `UserResponse` with 200 OK |
| **GET** | `/api/v1/user/{id}` | Retrieve user by ID | - | `UserResponse` with 200 OK |
| **PUT** | `/api/v1/users/{id}` | Update existing user | `UserRequest` | `UserResponse` with 200 OK |
| **DELETE** | `/api/v1/{id}` | Delete user by ID | - | 204 No Content |

### Request/Response Models

**UserRequest** (for Create/Update):
```json
{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

**UserResponse** (for Read/Update responses):
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```

### Example API Calls

#### Create User
```bash
POST /api/v1/users
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com"
}
```
**Response**: 201 Created with Location header `/api/v1/users1`

#### Get All Users
```bash
GET /api/v1/users
```
**Response**: 200 OK with list of users

#### Get User by ID
```bash
GET /api/v1/user/1
```
**Response**: 200 OK with user details

#### Update User
```bash
PUT /api/v1/users/1
Content-Type: application/json

{
  "name": "Jane Doe",
  "email": "jane.doe@example.com"
}
```
**Response**: 200 OK with updated user details

#### Delete User
```bash
DELETE /api/v1/1
```
**Response**: 204 No Content

## 💾 Database Configuration

The application uses H2 in-memory database with the following configuration:

- **Console URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:userdb`
- **Username**: `sa`
- **Password**: (empty)

## 🛡️ Exception Handling

The application implements a comprehensive global exception handling mechanism using `@ControllerAdvice`, providing:
- Consistent error response structure
- Proper HTTP status codes for different error scenarios
- Meaningful error messages for debugging
- Validation error handling


## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License.

---

**Built with ❤️ using Spring Boot**

---
