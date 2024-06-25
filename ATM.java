import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Account class to represent a bank account
class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));
            return true;
        } else {
            return false; // Insufficient balance
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}

// Transaction class to represent individual transactions
class Transaction {
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

// ATM class to manage interactions with users
public class ATM {
    private List<Account> accounts;
    private Scanner scanner;

    public ATM() {
        this.accounts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean quit = false;
        while (!quit) {
            System.out.println("Welcome to the ATM system!");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer (Not implemented)");
            System.out.println("4. Transaction History");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    performWithdraw();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    System.out.println("Transfer functionality is not implemented.");
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    quit = true;
                    System.out.println("Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
                    break;
            }
        }
    }

    private void performWithdraw() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character

            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private void performDeposit() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline character

            account.deposit(amount);
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    private void showTransactionHistory() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = findAccount(accountNumber);
        if (account != null) {
            List<Transaction> transactions = account.getTransactions();
            System.out.println("Transaction History for Account " + accountNumber + ":");
            for (Transaction transaction : transactions) {
                System.out.println(transaction.getType() + ": $" + transaction.getAmount());
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null; // Account not found
    }

    public static void main(String[] args) {
        // Create some sample accounts
        Account account1 = new Account("123456", 1000.0);
        Account account2 = new Account("654321", 500.0);

        // Initialize ATM with accounts
        ATM atm = new ATM();
        atm.accounts.add(account1);
        atm.accounts.add(account2);

        // Run ATM system
        atm.run();
    }
}
