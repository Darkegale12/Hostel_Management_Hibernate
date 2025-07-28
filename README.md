# 🏨 Hostel Management System (Java + Hibernate)

A powerful backend system to manage hostel operations — including room allocation, user login, service request handling, and hostel rule generation. Built with Java 17,  Hibernate ORM, and MySQL, the system follows enterprise-grade practices using a clean, modular architecture.

---

## 🚀 Key Features

- ✅ **Layered Architecture** (Configuration → Controller → DAO → Service → Entity)
- 🧾 Hostel rules PDF generation module
- ✉️ OTP-based email service integration using JavaMail
- 🔒 Secure structure, ready to extend with Spring Security
- 📚 User interface console (for testing basic functionality)
- 🛏️ Room allocation logic with user mapping
---

## 🛠️ Tech Stack

| Component         | Technology Used               |
|-------------------|-------------------------------|
| Language          | Java 17                       |             |
| ORM               | Hibernate + JPA               |
| Database          | MySQL                         |
| Build Tool        | Maven                         |
| Email Service     | JavaMail API                  |
| PDF Generation    | iText / Java FPDF Generator   |
| IDE               | Eclipse / IntelliJ            |

---

## 🧱 Project Structure
```
com.hostel/
├── Configuration/
│ └── HBconfiguration.java # Hibernate setup
│
├── Controller/
│ └── userController.java # RESTful APIs
│
├── DAO/
│ └── userDAO.java # DB operations
│
├── Entity/
│ ├── hostel_room_database.java # Room & services data
│ └── User_Login_Entity.java # User login records
│
├── Service/
│ └── userService.java # Business logic
│
├── User/
│ ├── HostelRulesPDFGenerator.java # Generates hostel rules PDF
│ ├── OtpEmailService.java # Sends OTP to email
│ └── User_Interface.java # Console UI (test/dummy frontend)
│
├── hibernate.cfg.xml # Hibernate DB config
└── application.properties # Spring Boot config
```

---
### 📦 How to Download & Run

- Download the ZIP file or clone the repo  
- Open it in Eclipse  
- Add JAR files in the `/lib/` folder to your build path  
- Configure your MySQL DB in `hibernate.cfg.xml`  
- Run `User_Interface.java` and follow the menu!

---

For quick local testing and interaction without frontend:

- Register user (masked password)
- Book insertion, search, deletion (from an old library logic)
- Search by author, year, keyword
- Demonstrates user-driven flow through Scanner I/O

> ✅ You can swap this dummy frontend later with a React, Angular, or Flutter UI.

---

## 🔐 Design Principles

- ✅ Follows **SOLID** principles
- ✅ Clean separation of concerns
- ✅ All CURD operation with special features like mail and pdf generation
- ✅ Easily extendable for Spring Security, Docker, or Swagger

---

## 📦 Future Enhancements

- 🔐 Spring Security for login auth
- 📊 Admin dashboard panel with metrics
- 🐳 Docker support for easy deployment
- ☁️ Cloud MySQL + Email Gateway integration
- 🧪 JUnit + Mockito test coverage

---

## 👨‍💻 Author

**Vishwajeet More**  
📧 vishwajeet12.messi@gmail.com  
📧 vishwajeetmore2023.comp@mmcoe.edu.in  
🌐 GitHub: [Darkegale12](https://github.com/Darkegale12)

---



