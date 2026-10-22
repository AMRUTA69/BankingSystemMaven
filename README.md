# Banking System Application (Maven)

A console-based Banking System application built in Java using Object-Oriented Programming (OOP) principles. This project demonstrates the use of Maven for build management and JUnit for unit testing.

## ✨ Features

- ✅ **Account Management:** Create Savings and Checking accounts.
- ✅ **Deposit & Withdraw:** Handle basic banking transactions.
- ✅ **Overdraft Protection:** Checking accounts allow overdrafts up to $500.
- ✅ **Minimum Balance:** Savings accounts enforce a minimum balance of $100.
- ✅ **Transfer Money:** Transfer funds between accounts securely.
- ✅ **Exception Handling:** Throws `IllegalArgumentException` for invalid transactions.
- ✅ **JUnit Tests:** Comprehensive test suite using `assertThrows` for error conditions.

## 🛠️ Technologies Used

- **Language:** Java (JDK 21)
- **Build Tool:** Apache Maven
- **Testing Framework:** JUnit 5
- **Data Structure:** `HashMap` (for storing accounts)

## 📁 Project Structure

```text
BankingSystemMaven/
├── src/
│   ├── main/
│   │   └── java/
│   │       ├── Account.java
│   │       ├── SavingsAccount.java
│   │       ├── CheckingAccount.java
│   │       └── BankingSystem.java
│   └── test/
│       └── java/
│           └── BankingSystemTest.java
├── pom.xml
├── .gitignore
└── README.md
