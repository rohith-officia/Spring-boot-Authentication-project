# Spring-boot-Authentication-project

# Spring Boot Authentication API

This project is a **Spring Boot REST API** for user authentication. It includes:

- User **Registration** with password hashing
- User **Login** with password verification
- **Password Reset** functionality
- Public **Checking Endpoint** for testing
- Basic **Spring Security** configuration

---

## 📁 Project Structure

com.example.demo
│
├─ Config
│ └─ SecurityConfig.java
│
├─ Controller
│ ├─ AuthenticationController.java
│ └─ CheckingApplicationController.java
│
├─ Service
│ ├─ UserService.java
│ └─ ServiceImp
│ └─ UserServiceImp.java
│
├─ Repository
│ └─ UserRepository.java
│
├─ Model
│ └─ UserModel.java
│
├─ Dto
│ ├─ LoginDTO.java
│ └─ RegisterDTO.java
└─ Application.java
