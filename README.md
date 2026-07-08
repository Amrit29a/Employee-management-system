# 🚀 Employee Management System

A RESTful Employee Management System built using **Spring Boot**, **Spring Data JPA**, and **H2/MySQL Database**. This project demonstrates CRUD operations, validation, exception handling, and layered architecture following industry best practices.

---

## 📌 Features

- ✅ Create Employee
- ✅ View All Employees
- ✅ View Employee by ID
- ✅ Update Employee Details
- ✅ Delete Employee
- ✅ Input Validation
- ✅ Global Exception Handling
- ✅ RESTful API Architecture
- ✅ Database Persistence using Spring Data JPA
- ✅ Tested using Postman

---

## 🛠 Tech Stack

| Technology | Used |
|------------|------|
| Java | 26 |
| Spring Boot | 4.1.0 |
| Spring MVC | REST APIs |
| Spring Data JPA | Database Operations |
| H2 Database / MySQL | Database |
| Maven | Dependency Management |
| Lombok | Boilerplate Code Reduction |
| Bean Validation | Input Validation |
| Postman | API Testing |

---

## 📂 Project Structure

```
EmployeeManagement
│
├── controller
│     └── EmployeeController
│
├── service
│     └── EmployeeService
│
├── repository
│     └── EmployeeRepository
│
├── entity
│     └── Employee
│
├── exception
│     ├── EmployeeNotFoundException
│     └── GlobalExceptionHandler
│
├── resources
│     ├── application.properties
│
└── EmployeeManagementApplication
```

---

## 📊 Employee Entity

| Field | Type |
|-------|------|
| id | Long |
| name | String |
| email | String |
| department | String |
| salary | Double |
| dateOfJoining | LocalDate |

---

# 📡 REST API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/employees` | Add Employee |
| GET | `/employees` | Get All Employees |
| GET | `/employees/{id}` | Get Employee by ID |
| PUT | `/employees/{id}` | Update Employee |
| DELETE | `/employees/{id}` | Delete Employee |

---

# 📥 Sample JSON Request

```json
{
    "name": "Amrita Singh",
    "email": "amrita@gmail.com",
    "department": "IT",
    "salary": 55000,
    "dateOfJoining": "2026-07-07"
}
```

---

# 📤 Sample JSON Response

```json
{
    "id": 1,
    "name": "Amrita Singh",
    "email": "amrita@gmail.com",
    "department": "IT",
    "salary": 55000,
    "dateOfJoining": "2026-07-07"
}
```

---

# ⚙️ Installation

### Clone Repository

```bash
git clone https://github.com/yourusername/EmployeeManagement.git
```

### Move to Project

```bash
cd EmployeeManagement
```

### Build Project

```bash
mvn clean install
```

### Run Project

```bash
mvn spring-boot:run
```

The application will start at:

```
http://localhost:8080
```

---

# 🗄 Database

Default Database:

- H2 Database

You can also configure:

- MySQL

Update the `application.properties` file with your database credentials if using MySQL.

---

# ✔ Validation

The application validates:

- Name cannot be empty
- Email must be valid
- Department cannot be empty
- Salary must be greater than 0

---

# ⚠ Exception Handling

Global exception handling is implemented using:

- `@ControllerAdvice`
- Custom `EmployeeNotFoundException`

Returns meaningful HTTP status codes and error messages.

---

# 🧪 API Testing

All REST APIs were tested using **Postman**.

Example Endpoints:

```
POST    /employees
GET     /employees
GET     /employees/{id}
PUT     /employees/{id}
DELETE  /employees/{id}
```

---

# 🚀 Future Enhancements

- Employee Search
- Pagination & Sorting
- Department Module
- Authentication & Authorization
- Swagger API Documentation
- Docker Deployment
- Unit & Integration Testing

---

# 📸 Screenshots

> Add screenshots here

- Home
- Postman GET
- Postman POST
- Postman PUT
- Postman DELETE
- H2 Database Console

---

# 👩‍💻 Author

**Amrita Singh**

Frontend Developer | UI/UX Designer | Java Developer

📧 Email: amrita98shalu@gmail.com

🔗 LinkedIn: https://www.linkedin.com/in/amrita-singh-5ba95b294?utm_source=share_via&utm_content=profile&utm_medium=member_android

💻 GitHub: https://github.com/Amrit29a

---

## ⭐ If you found this project useful, don't forget to Star the repository!
