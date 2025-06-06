# Hibernate-and-JSP-Bank

Hello World!

# Project Overview

Hibernate and JSP Bank is a dynamic web banking application developed using JSP, Hibernate, POJO, and MySQL. The application allows users to perform essential banking operations such as:
- Creating a user profile
- Sending and receiving money
- Depositing cheques
- Checking account balances
- Viewing and updating account information

## The application employs the MVC (Model-View-Controller) architecture:

Model: Java POJOs mapped to database tables using Hibernate
View: JSP files for the user interface
Controller: Servlets handling business logic and request processing

## Tech Stack

- Frontend: HTML, JSP
- Backend: Java (Servlets, POJOs)
- ORM: Hibernate
- Database: MySQL
- Architecture: MVC (Model-View-Controller)

## Features

- User Registration: Users can create profiles by entering personal information.
- Fund Transfer: Send and receive money between users by providing recipient details.
- Cheque Deposit: Deposit funds by entering a valid cheque number.
- Balance Inquiry: View current account balance.
- Profile Management: Update existing account information.
- Input Validation: Utilizes regular expressions to validate mobile numbers, transaction amounts, and cheque numbers.
- Database Mapping: Hibernate maps POJO classes to database tables, ensuring seamless data persistence.
