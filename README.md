# 🏥 SBHospital – Hospital Management System

A basic backend application developed using Spring Boot for managing hospital-related information such as doctors, patients, appointments, and billing.

> **Status:** Completed basic version


## 📌 Overview

SBHospital is a Spring Boot backend project designed to demonstrate the development of a basic hospital management system.

The application organizes hospital data into different entities and provides a structured backend architecture for managing:

- Doctors
- Patients
- Appointments
- Bills

The project follows a layered architecture to separate API handling, business logic, database operations, and entity models.



## ✨ Features

- 👨‍⚕️ Doctor management
- 🧑‍⚕️ Patient management
- 📅 Appointment management
- 💳 Billing management
- ➕ Create records
- 🔍 Retrieve records
- ✏️ Update records
- 🗑️ Delete records
- 🌐 REST API-based backend
- 🗄️ Database persistence using MySQL



## 🛠️ Technologies Used

- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Maven**
- **REST APIs**



## 🏗️ Architecture

The application follows a layered architecture:
        Client -> REST Controller -> Service -> Repository -> MySQL
