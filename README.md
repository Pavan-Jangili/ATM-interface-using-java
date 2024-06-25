# ATM-interface-using-java
## Description
This Java application simulates an ATM system where users can perform basic banking operations such as withdrawals, deposits, and view transaction history.

## Components

### Account Class
The `Account` class represents a bank account with attributes for `accountNumber`, `balance`, and `transactions`.

- **Attributes**: 
  - `accountNumber`: Identifies the account uniquely.
  - `balance`: Stores the current balance of the account.
  - `transactions`: Maintains a list of transactions (deposits and withdrawals).
- **Methods**: 
  - `deposit(double amount)`: Adds the specified amount to the account balance and records a deposit transaction.
  - `withdraw(double amount)`: Subtracts the specified amount from the account balance if sufficient funds are available, recording a withdrawal transaction.
  - `getTransactions()`: Retrieves the list of transactions for the account.

### Transaction Class
The `Transaction` class models individual transactions within an account.

- **Attributes**: 
  - `type`: Describes the type of transaction (e.g., "Deposit", "Withdrawal").
  - `amount`: Stores the transaction amount.
- **Constructor**: 
  - Initializes a transaction with a type and amount.
- **Methods**: 
  - Provides getters for `type` and `amount`.

### ATM Class
The `ATM` class manages interactions with users, utilizing the `Account` and `Transaction` classes.

- **Attributes**: 
  - `accounts`: A list of `Account` objects managed by the ATM.
  - `scanner`: A `Scanner` object to read user input.
- **Methods**: 
  - `run()`: Main control method that displays a menu of options (Withdraw, Deposit, etc.) and handles user input.
  - `performWithdraw()`, `performDeposit()`, `showTransactionHistory()`: Methods that execute respective operations based on user input.
  - `findAccount(String accountNumber)`: Searches for an account by its account number.

### Main Method
The `main` method initializes the ATM system with sample accounts and starts the ATM.

- **Initialization**: 
  - Creates sample `Account` instances (`account1`, `account2`) with predefined account numbers and initial balances.
  - Initializes an `ATM` object (`atm`) and adds the sample accounts to its list.
  - Calls `atm.run()` to start the ATM system.

## Usage
1. Compile and run the `ATM.java` file.
2. Follow the on-screen prompts to select operations:
   - Choose an option from the menu (1 for Withdraw, 2 for Deposit, etc.).
   - Enter the account number when prompted.
   - Enter the amount for withdrawals and deposits.
3. Transaction history can be viewed by selecting option 4 from the menu.
