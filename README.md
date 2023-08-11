# MVC App using Spring Boot, Spring Security, and Thymeleaf

## Description
Displays list of books and their info from database. Only allows authorized logged-in users to have permission to edit and add books

## To start:
Start mysql with: mysql -u root -p

Populate mysql database with commands: "source ..../db/ddl.sql", "source ..../sql/schema.sql", "source ..../sql/test-data.sql"

Run command: mvn spring-boot:run

Open localhost:8080/books
