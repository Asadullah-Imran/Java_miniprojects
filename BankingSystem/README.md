# Java Banking System Project
## Introduction
This project is a simple banking system implemented in Java. It provides a graphical user interface (GUI) for users to perform various operations, including logging in, depositing money, withdrawing money, transferring funds, and checking previous transactions. The application interacts with a MySQL database to store user information and transaction history.

## Project Structure
### Database Structure
The project uses a MySQL database named bankapp with two tables: users and transactions.

users Table
id: Unique identifier for each user.
username: User's username.
password: User's password.
current_balance: User's current account balance.
transactions Table
id: Unique identifier for each transaction.
transaction_amount: Amount involved in the transaction.
transaction_date: Date and time of the transaction.
transaction_type: Type of transaction (e.g., deposit, withdrawal, transfer).
user_id: Foreign key linking to the id in the users table, indicating the user associated with the transaction.
### GUI Features
Login System: Users can log in using their username and password.
Deposit: Users can deposit money into their account.
Withdraw: Users can withdraw money from their account.
Transfer: Users can transfer funds to another user's account.
Check Previous Transactions: Users can view their transaction history.
## Setting Up the Project
### Requirements
Java Development Kit (JDK)
MySQL Database
MySQL Connector/J library
GUI library (e.g., JavaFX, Swing)