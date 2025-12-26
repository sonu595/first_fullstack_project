#  Quiz & Assessment Backend System

A **production-ready Spring Boot REST API** for building powerful quiz and assessment applications.  
This backend system provides **secure user authentication**, **robust question management**, and a **clean layered architecture** following industry standards.

---

## ✨ Key Features

### 🔐 Secure Authentication
- Complete **user signup & login**
- Password hashing using **BCryptPasswordEncoder**

### 🛡️ Advanced Security
- Spring Security integration  
- CSRF disabled for APIs
- Properly configured CORS for Flutter / Web

### ✅ Strong Input Validation
- Jakarta Validation  
- Email format validation  
- Non-blank fields  
- Password constraints

### 🎯 Dynamic Question Engine
- Get questions by **category**
- Filter by **difficulty levels**
- Custom JPA queries

### 🔁 Standardized API Responses
- Well-structured response objects  
- Consistent API communication

---

## 🛠️ Tech Stack

| Layer | Technology |
|-------|------------|
| Framework | Spring Boot 3.x |
| Security | Spring Security |
| Database ORM | Spring Data JPA / Hibernate |
| Database | PostgreSQL / MySQL |
| Validation | Jakarta Bean Validation |

---

## 📡 API Endpoints

### 🔐 Authentication (`/api/auth`)

| Method | Endpoint | Payload | Description |
|--------|---------|---------|-------------|
| POST | `/signup` | `SignupRequest` | Registers a new user |
| POST | `/login` | `LoginRequest` | Validates credentials |

---

### ❓ Question Management (`/api/questions`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/questions` | Get all questions |
| GET | `/api/questions/{category}/{level}` | Get questions by category & difficulty |
| GET | `/api/questions/categories` | Get distinct list of categories |
| GET | `/api/questions/{id}` | Get question by ID |

---

## 📂 Project Structure

```
src/main/java/com/example/project
│
├── config
│   └── SecurityConfig.java
│
├── controller
│   └── AuthController.java
│   └── QuestionController.java
│
├── service
│   └── AuthService.java
│   └── QuestionService.java
│
├── model
│   └── User.java
│   └── Question.java
│
├── dto
│   └── SignupRequest.java
│   └── LoginRequest.java
│
└── repository
    └── UserRepository.java
    └── QuestionRepository.java
```
---

## 🚀 Getting Started

### 1️⃣ Clone Repository
```bash
git clone <your-repository-url>
cd project-folder
```

### 2️⃣ Configure Database
Update this file:
```
src/main/resources/application.properties
```

Set:
```
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

---

### 3️⃣ Run Application
```bash
mvn spring-boot:run
```

OR using IDE  
➡️ Run `Application.java`

---

## 📌 Notes
- Works seamlessly with **Flutter / Web frontend**
- Built using **clean architecture**
- Scalable and production-ready

---

## 💡 Contribution
Feel free to fork, enhance, and submit PRs!
