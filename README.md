# Student_Data_Entry_JDBC

## Description

This project is a **Java-based menu-driven application** for managing student records using **MySQL with JDBC integration**. It allows users to perform basic **CRUD (Create, Read, Update, Delete)** operations and simulates real-world student data handling by storing and retrieving information directly from a MySQL database.

##  Features

1. **Add Student** – Insert a new student record into the database.
2. **Display Students** – View all student records from the database.
3. **Search by PRN** – Find a student using their PRN number.
4. **Search by Name** – Retrieve a student using their full name.
5. **Search by Position** – Access student details by index position.
6. **Update Student** – Modify an existing student’s information.
7. **Delete Student** – Remove a student’s record using PRN.
8. **JDBC Integration** – Connects to MySQL using JDBC for persistent data handling.


## Code Structure

```
Student-Data-Entry-Java-JDBC/
│
├── Main.java                # User interface and menu logic
├── Student.java             # Student model class (
├── StudentOperations.java   # JDBC-based implementation of student operations
└── README.md                # Project documentation
```


##  Setup Instructions

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/Student_Data_Entry_JDBC.git
   cd Student_Data_Entry_JDBC
   ```

2. **Create the MySQL Database**

   ```sql
   CREATE DATABASE studentdb;
   USE studentdb;

   CREATE TABLE students (
       prn BIGINT PRIMARY KEY,
       name VARCHAR(100),
       branch VARCHAR(50),
       batch VARCHAR(20),
       cgpa DOUBLE
   );
   ```

3. **Update Credentials in `StudentOperations.java`**
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/studentdb";
   private static final String USER = "root";
   private static final String PASSWORD = "your_password";
   ```

4. **Compile and Run the Program**
   ```bash
   javac Main.java
   java Main
   ```


##  Method Descriptions

### `StudentOperations.java`

- **addStudent(Student student)**: Adds a new student to the database.
- **displayStudents()**: Retrieves and displays all student records.
- **searchByPRN(long prn)**: Finds a student by their PRN number.
- **searchByName(String name)**: Finds a student by name.
- **searchByPosition(int pos)**: Retrieves student at the specified position.
- **updateStudent(Student student)**: Updates the record based on PRN.
- **deleteStudent(long prn)**: Deletes the record matching the PRN.

### `Student.java`

- A simple Java file representing a student with:
  - PRN (Primary Key)
  - Name
  - Branch
  - Batch
  - CGPA
- Includes getter/setter methods and a `display()` method for output.

### `Main.java`

- Provides a **menu-driven interface** for interacting with the user.
- Handles input, calls appropriate methods from `StudentOperations`.
- Uses try-catch blocks to manage incorrect inputs gracefully.



##  Sample Interaction

```
Menu:
1. Add Student
2. Display Students
3. Search Student by PRN
4. Search Student by Name
5. Search Student by Position
6. Update Student Details
7. Delete Student
0. Exit
Enter your choice: 1

Enter Name: Vedant
Enter PRN: 23070126143
Enter Branch: AIML
Enter Batch: B3
Enter CGPA: 8.8
Student added successfully.
```



##  Coding Guidelines Followed

- **Modular Structure**: Separated logic into multiple classes.
- **Object-Oriented Principles**: 
  - Encapsulation using private fields and public methods.
  - Abstraction through separated responsibilities.
- **Readable Code**: Proper indentation, spacing, and naming conventions.
- **Exception Handling**: All JDBC operations are wrapped in try-catch blocks.
- **Descriptive Comments**: Each method and logic block is documented.




