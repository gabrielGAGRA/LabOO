# Library Management System

## Overview
The Library Management System is a Java-based application designed to manage the operations of a public library. It allows for the registration of users, management of books, and control of book loans. The system is built using object-oriented principles, ensuring modularity and maintainability.

## Features
- **User Management**: 
  - Register new users with unique identification.
  - Search for users by name or ID.
  - Track user borrowing status and restrictions.

- **Book Management**: 
  - Add new books with detailed information.
  - Classify books into categories: recent, collection, and reference.
  - Manage multiple copies of the same book.

- **Loan Management**: 
  - Create and manage book loans.
  - Renew loans and track overdue items.
  - Enforce borrowing limits and penalties for late returns.

## Project Structure
```
library-management-system
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── biblioteca
│   │   │           ├── App.java
│   │   │           ├── model
│   │   │           │   ├── Usuario.java
│   │   │           │   ├── Livro.java
│   │   │           │   └── Emprestimo.java
│   │   │           ├── service
│   │   │           │   ├── UsuarioService.java
│   │   │           │   ├── LivroService.java
│   │   │           │   └── EmprestimoService.java
│   │   │           └── util
│   │   │               └── DateUtils.java
│   │   └── resources
│   │       └── data.txt
│   └── test
│       └── java
│           └── com
│               └── biblioteca
│                   ├── UsuarioServiceTest.java
│                   ├── LivroServiceTest.java
│                   └── EmprestimoServiceTest.java
├── pom.xml
└── README.md
```

## Setup Instructions
1. Clone the repository:
   ```
   git clone https://github.com/yourusername/library-management-system.git
   ```
2. Navigate to the project directory:
   ```
   cd library-management-system
   ```
3. Build the project using Maven:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn exec:java -Dexec.mainClass="com.biblioteca.App"
   ```

## Usage
Upon running the application, a textual menu will be presented to the user (library staff) for interaction. The menu allows for:
- Adding new users and books.
- Managing book loans.
- Renewing loans and returning books.
- Listing overdue loans for user notifications.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.