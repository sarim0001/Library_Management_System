# Library Management System

This **Library Management System** is a simple Java-based application that allows users to manage a collection of books and library memberships. It includes functionality for adding, selling, renting, and returning books, as well as creating and managing memberships.

## Overview

The Library Management System simulates the operations of a small book store or library. The application allows administrators to:

- Add books to the library
- Sell or rent books to users
- Track book stock
- Create memberships for users
- Manage rented and returned books
- Remove books or memberships

## Features

- **Book Management**: Add, display, remove, sell, and rent books from the store.
- **Membership Management**: Create and display user memberships, including membership duration.
- **Stock Management**: Track and update the stock of books available in the store.
- **Interactive Menu**: User-friendly menu for interacting with the system.

## Project Structure

The project consists of three main classes:

- `Book.java`: Represents a book in the library with properties such as ID, name, author, published date, stock, and buyer information.
- `Membership_user.java`: Represents a library member with properties like name, age, address, membership ID, and the list of borrowed books.
- `Library_Management_System.java`: The main class that provides a menu-driven interface for the system's operations.

## Getting Started

### Prerequisites

To run this project, you need:

- [Java JDK 8 or above](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- A code editor or IDE such as [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/)

### Running the Application

1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/your-repo-name.git
    ```

2. Navigate to the project directory and compile the Java files:
    ```bash
    javac Library_Management_System.java Book.java Membership_user.java
    ```

3. Run the application:
    ```bash
    java Library_Management_System
    ```

4. Follow the on-screen menu to interact with the system.

## Usage

The application provides the following menu options:

1. **Add Book To Store**: Adds a new book to the library with details like book ID, name, author, and stock.
2. **Sell Book**: Decreases the stock of the book by 1 and registers the buyer's name.
3. **Rent Book**: Rents a book to a member if it’s available in stock.
4. **Return Book**: Returns a rented book, increasing its stock by 1.
5. **Display Book Info**: Displays the information of a specific book.
6. **Create Membership**: Adds a new user to the library system with membership details.
7. **Display Member Info**: Displays information about a specific library member.
8. **Remove Book From Store**: Deletes a book from the library’s collection.
9. **Remove Membership**: Deletes a member from the system.
10. **Exit**: Exits the application.

## Contributing

Contributions are welcome! Feel free to fork the repository and submit a pull request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/your-feature`)
3. Commit your changes (`git commit -m 'Add some feature'`)
4. Push to the branch (`git push origin feature/your-feature`)
5. Open a pull request

## Acknowledgments

- Java Documentation: [Oracle Java Documentation](https://docs.oracle.com/en/java/)
- [Your inspiration or any other resources]

---

Feel free to adapt and expand this file based on your project's needs!
