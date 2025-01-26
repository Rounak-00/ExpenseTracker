# ExpenseTracker

## Description
ExpenseTracker is a Spring Boot-based application designed to help users manage their financial transactions efficiently. The project provides a RESTful API to perform CRUD operations on the database, allowing users to track income, expenses, and statistics. Swagger is integrated for API documentation.

---

## Features
- **Spring Boot Framework**: Provides a robust foundation for building and deploying the application.
- **JPA (Java Persistence API)**: Manages database operations with ease.
- **MySQL Connector**: Connects the application to a MySQL database for storing and retrieving data.
- **Lombok**: Reduces boilerplate code for entity classes.
- **Swagger**: Enables detailed API documentation and interactive testing.
- **CRUD Operations**: Full Create, Read, Update, and Delete functionalities for Income, Expense, and Statistics management.

---

## Technologies Used
- **Backend**: Spring Boot
- **Database**: MySQL
- **Libraries and Tools**: JPA, Lombok, Swagger
- **API**: RESTful API

---

## Setup and Installation
1. **Clone the Repository**:
   ```bash
   git clone <repository-url>
   ```

2. **Navigate to the Project Directory**:
   ```bash
   cd ExpenseTracker
   ```

3. **Configure Database**:
   Update `src/main/resources/application.properties` with your MySQL database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

4. **Build the Project**:
   ```bash
   ./mvnw clean install
   ```

5. **Run the Application**:
   ```bash
   ./mvnw spring-boot:run
   ```

6. **Access Swagger UI**:
   Open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) in your browser for API documentation.

---

## API Endpoints
Here are the major endpoints exposed by the application:

### Income
- **GET** `/api/income` - Retrieve all income records.
- **POST** `/api/income` - Add a new income record.
- **PUT** `/api/income/{id}` - Update an income record by ID.
- **DELETE** `/api/income/{id}` - Delete an income record by ID.

### Expense
- **GET** `/api/expense` - Retrieve all expense records.
- **POST** `/api/expense` - Add a new expense record.
- **PUT** `/api/expense/{id}` - Update an expense record by ID.
- **DELETE** `/api/expense/{id}` - Delete an expense record by ID.

### Statistics
- **GET** `/api/stats` - Retrieve financial statistics.

---

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

---

## Contact
For any questions or issues, please contact:
- **Name**: Rounak
- **Email**: rounakmazumder309@gmail.com

---

## Acknowledgments
Special thanks to the open-source community and Spring Boot documentation for their invaluable resources.

