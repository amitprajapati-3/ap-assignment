input:
import java.util.HashMap;
import java.util.Map;


class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to account " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + " from account " + accountNumber);
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
        }
    }
}


class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void displayAllAccounts() {
        for (Account account : accounts.values()) {
            System.out.println("Account Number: " + account.getAccountNumber() +
                               ", Holder: " + account.getAccountHolderName() +
                               ", Balance: $" + account.getBalance());
        }
    }
}


public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Account acc1 = new Account("1001", "Alice", 5000);
        Account acc2 = new Account("1002", "Bob", 3000);

        bank.addAccount(acc1);
        bank.addAccount(acc2);

       
        System.out.println("All Accounts:");
        bank.displayAllAccounts();

        
        acc1.deposit(1500);
        acc2.withdraw(500);

        
        System.out.println("\nUpdated Accounts:");
        bank.displayAllAccounts();
    }
}
output:
All Accounts:
Account Number: 1001, Holder: Alice, Balance: $5000.0
Account Number: 1002, Holder: Bob, Balance: $3000.0
Deposited $1500.0 to account 1001
Withdrew $500.0 from account 1002

Updated Accounts:
Account Number: 1001, Holder: Alice, Balance: $6500.0
Account Number: 1002, Holder: Bob, Balance: $2500.0

