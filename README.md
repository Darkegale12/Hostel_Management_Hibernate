# Hostel Management System

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-red.svg)
![MySQL](https://img.shields.io/badge/MySQL-Database-yellow.svg)
![Maven](https://img.shields.io/badge/Maven-Build-orange.svg)
![JavaMail](https://img.shields.io/badge/JavaMail-API-green.svg)
![PDF](https://img.shields.io/badge/PDF-iText%2FFPDF-lightgrey.svg)

---

## 📋 Overview

A robust and modular backend system to manage hostel operations — including room allocation, user login, service request handling, PDF rule generation, and OTP email verification. Built with **Java 17**, **Hibernate ORM**, and **MySQL**, it follows enterprise-grade practices with a clean multi-layered architecture.

---

## 🚀 Key Features

- ✅ **Layered Architecture** (`Configuration → Controller → DAO → Service → Entity`)
- 🛏️ Room allocation logic with user mapping
- 🧾 Hostel rules **PDF generation**
- ✉️ **OTP email** service integration using JavaMail
- 📚 Console-based user interface for quick testing
- 🔒 Secure structure, ready to extend with Spring Security

---

## 🛠️ Tech Stack

| Component         | Technology Used               |
|-------------------|-------------------------------|
| Language          | Java 17                       |
| ORM               | Hibernate + JPA               |
| Database          | MySQL                         |
| Build Tool        | Maven                         |
| Email Service     | JavaMail API                  |
| PDF Generator     | iText / Java FPDF Generator   |
| IDE               | Eclipse / IntelliJ IDEA       |

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

## 🧪 Console UI Features (User_Interface.java)

For quick local testing without a full frontend:

- Register user (with masked password)
- Book insertion, search, deletion (based on test library logic)
- Search by author, year, keyword
- Demonstrates user-driven interaction via Scanner I/O

> ✅ You can later replace this dummy frontend with React, Angular, or Flutter UI.

---

## 🔐 Design Principles

- ✅ Follows **SOLID** principles
- ✅ Clean separation of concerns
- ✅ Supports all CRUD operations + PDF/email features
- ✅ Easily extendable with Spring Security, Swagger, and Docker

---

## 🚧 Future Enhancements

- 🔐 Spring Security for authentication
- 📊 Admin dashboard panel with analytics
- 🐳 Docker support for containerized deployment
- ☁️ Cloud DB & hosted email gateway integration
- 🧪 Unit testing with JUnit + Mockito

---

## 👨‍💻 Author

**Vishwajeet More**  
📧 vishwajeet12.messi@gmail.com  
📧 vishwajeetmore2023.comp@mmcoe.edu.in  
🌐 GitHub: [Darkegale12](https://github.com/Darkegale12)

---
