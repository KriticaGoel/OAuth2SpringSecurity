# Spring Boot User Registration Service

This project is a Spring Boot application for user registration, including validation for username, password, email, and phone number.

## Features

- User sign-up with validation
- DTOs with field-level validation using Jakarta Validation
- Maven-based build

## Technologies

- Java
- Spring Boot
- Maven
- Lombok
- Jakarta Validation

## Getting Started

1. **Clone the repository:**  git clone https://github.com/KriticaGoel/OAuth2SpringSecurity.git cd your-repo
2. **Build the project:**  mvn clean install
3. **Run the application:** mvn spring-boot:run

## Project Structure
OAuth2SpringSecurity/

├── src/

│   ├── main/

│   │   ├── java/

│   │   │   └── com/

│   │   │       └── example/

│   │   │           ├── model
│   │   │           │   └── BaseModel.java
│   │   │           │   └── User.java
│   │   │           │   └── Token.java

│   │   │           ├── repository/
│   │   │           │   └── TokenRepository.java
│   │   │           │   └── UserRepository.java

│   │   │           └── controller
|   |   |                └──AuthController.java

│   │   │           ├── dto
│   │   │           │   └── SignUpRequestDto.java
│   │   │           │   └── UserDto.java
│   │   │           │   └── LoginRequestDto.java
│   │   │           │   └── ExceptionDto.java

│   │   │           ├── service
│   │   │           │   └── AuthServiceImpl.java

│   │   │           ├── exception
│   │   │           │   └── GlobalException.java

│   │   │           │   └── PasswordValidationFail.java

│   │   │           │   └── TokenInvalidException.java

│   │   │           │   └── UserAlreadyExistException.java

│   │   │           │   └── UsernameNotFoundException.java

│   │   │           │   └── ValidateException.java

│   │   │           ├── config

│   │   │           │   └── AppConfig.java

│   │   │           │   └── WebSecurityConfig.java

│   │   └── resources/

│   │       └── application.properties

│   └── test/
│       └── java/
│           └── com/
│               └── example/
├── pom.xml

└── README.md

- `config/`: Application and security configuration (`AppConfig.java`, `WebSecurityConfig.java`)
- `controller/`: REST controllers for authentication (`AuthController.java`)
- `dto/`: Data Transfer Objects for requests and responses
- `exception/`: Custom exception classes and global exception handling
- `model/`: Entity classes (`User`, `Role`, `Token`, etc.)
- `repository/`: Spring Data JPA repositories
- `service/`: Business logic and service implementations
- `utility/`: Enums and constants
