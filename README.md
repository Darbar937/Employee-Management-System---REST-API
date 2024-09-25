
# Employee Management System - REST API

This project is a Spring Boot-based REST API that allows CRUD (Create, Read, Update, Delete) operations on employee data. The API is designed to manage employee information like their ID, name, department, email, and mobile number.

## Features
- **Create** a new employee record.
- **Retrieve** all employee records or a specific employee by ID.
- **Update** employee details.
- **Delete** an employee.

## Technologies Used
- **Java 11+**
- **Spring Boot** 2.x.x
- **Spring Data JPA** (Hibernate)
- **MySQL** for database
- **Lombok** for reducing boilerplate code
- **Jakarta Bean Validation** for validating input data

## Prerequisites
Before you begin, ensure you have the following installed:
- JDK 11 or higher
- Maven 3.6+
- MySQL database

## Getting Started

### 1. Clone the repository
```bash
git clone https://github.com/username/employee-management-system.git
cd employee-management-system
```

### 2. Set up the MySQL database
Create a database in your MySQL server:
```sql
CREATE DATABASE employee_db;
```

### 3. Configure the application
Update the `src/main/resources/application.properties` file with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```

### 4. Run the Application
You can run the application using Maven:
```bash
mvn spring-boot:run
```

Alternatively, you can build the JAR and run it:
```bash
mvn clean package
java -jar target/employee-management-system-0.0.1-SNAPSHOT.jar
```

### 5. Access the API
The API will be running at `http://localhost:8080/api/v1/emp`.

You can test the endpoints using a tool like **Postman** or **cURL**.

## API Endpoints

| Method | Endpoint                    | Description                        |
|--------|-----------------------------|------------------------------------|
| GET    | `/api/v1/emp/{empId}`        | Get an employee by ID              |
| POST   | `/api/v1/emp`                | Create a new employee              |
| PUT    | `/api/v1/emp/{empId}`        | Update an employee's details by ID |
| DELETE | `/api/v1/emp/{empId}`        | Delete an employee by ID           |

### Example Request & Response

#### POST `/api/v1/emp`

**Request Body:**
```json
{
  "empName": "John Doe",
  "empDept": "Engineering",
  "email": "john.doe@example.com",
  "mobile": "9876543210"
}
```

**Response Body:**
```json
{
  "empId": 1,
  "empName": "John Doe",
  "empDept": "Engineering",
  "email": "john.doe@example.com",
  "mobile": "9876543210"
}
```

### Validation Example

If the request has invalid data, the API will respond with validation errors. For instance, if the email format is invalid or the mobile number isn't 10 digits long, you'll get an error response.

#### Invalid Request:
```json
{
  "empName": "",
  "empDept": "Engineering",
  "email": "invalid-email",
  "mobile": "123"
}
```

**Error Response:**
```json
{
  "status": 400,
  "errors": [
    "Employee name is mandatory",
    "Email should be valid",
    "Mobile number must be 10 digits"
  ]
}
```

## Entity Model

### Employee Entity:
```java
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long empId;

    @NotBlank(message = "Employee name is mandatory")
    private String empName;

    @NotBlank(message = "Department is mandatory")
    private String empDept;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is mandatory")
    private String email;

    @NotBlank(message = "Mobile number is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Mobile number must be 10 digits")
    private String mobile;
}
```

## Service Layer

The **EmployeeService** is responsible for handling business logic and interacting with the repository layer to fetch and manipulate employee data.

```java
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDto saveEmp(EmployeeDto empDto) {
        // Business logic for saving employee
    }

    public EmployeeDto fetEmp(long empId) {
        // Business logic for retrieving employee by ID
    }

    public EmployeeDto delEmp(long empId) {
        // Business logic for deleting employee by ID
    }

    public EmployeeDto upDateemp(long empId, EmployeeDto empDto) {
        // Business logic for updating employee details
    }
}
```

## Database Schema

The database schema for the `Employee` entity:

```sql
CREATE TABLE employees (
    emp_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    emp_name VARCHAR(255) NOT NULL,
    emp_dept VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    mobile VARCHAR(10) NOT NULL
);
```

## Running Tests

Unit tests for the service and controller layers should be written using **JUnit** and **Mockito**.

You can run the tests using Maven:
```bash
mvn test
```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---
