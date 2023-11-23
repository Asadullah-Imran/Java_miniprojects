# Java Banking System Project

## Introduction

This project is a simple banking system implemented in Java. It provides a graphical user interface (GUI) for users to perform various operations, including logging in, depositing money, withdrawing money, transferring funds, and checking previous transactions. The application interacts with a MySQL database to store user information and transaction history.

## Project Structure

### Database Structure

The project uses a MySQL database named bankapp with two tables: users and transactions.

```sql
CREATE SCHEMA `bankapp` ;

```

##### users Table:

- id: Unique identifier for each user.
- username: User's username.
- password: User's password.
- current_balance: User's current account balance.

```sql
CREATE TABLE `bankapp`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `current_balance` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));
```

##### transactions Table:

- id: Unique identifier for each transaction.
- transaction_amount: Amount involved in the transaction.
- transaction_date: Date and time of the transaction.
- transaction_type: Type of transaction (e.g., deposit, withdrawal, transfer).
- user_id: Foreign key linking to the id in the users table, indicating the user associated with the transaction.

```sql
CREATE TABLE `bankapp`.`transactions` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `transaction_amount` DECIMAL(10,2) NOT NULL,
  `transaction_date` DATETIME NOT NULL,
  `transaction_type` VARCHAR(45) NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `demo`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
```

### GUI Features

1. Login System: Users can log in using their username and password.
2. Deposit: Users can deposit money into their account.
3. Withdraw: Users can withdraw money from their account.
4. Transfer: Users can transfer funds to another user's account.
5. Check Previous Transactions: Users can view their transaction history.

## Setting Up the Project

### Requirements

Java Development Kit (JDK)
MySQL Database
MySQL Connector (JDBC)
GUI library (Swing)

## Contributing

If you'd like to contribute to this project, please follow these steps:

1. Fork the repository on GitHub.
2. Clone your forked repository to your local machine.

3. Create a new branch for your feature/bug fix.

4. Commit your changes and push to your fork.

5. Submit a pull request from your branch to the original repository.

## Author

- [Asadullah Imran](https://github.com/Asadullah-Imran)

[//]: # "- [Portfolio Website](https://yourportfolio.com)"

## License

This project is licensed under the [MIT License](https://github.com/Asadullah-Imran/Java_miniprojects/blob/main/LICENSE).
