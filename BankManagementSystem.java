import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class BankManagementSystem {
    private List<Account> accounts;
    private Scanner scanner;

    public BankManagementSystem() {
        this.accounts = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void createAccount() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume newline left-over
        Account account = new Account(accountNumber, accountHolderName, balance);
        accounts.add(account);
        System.out.println("Account created successfully!");
    }

    public void deposit() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.print("Enter amount to deposit: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over
                account.setBalance(account.getBalance() + amount);
                System.out.println("Deposit successful!");
                return;
            }
        }
        System.out.println("Account not found!");
    }

    public void withdraw() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.print("Enter amount to withdraw: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline left-over
                if (account.getBalance() >= amount) {
                    account.setBalance(account.getBalance() - amount);
                    System.out.println("Withdrawal successful!");
                } else {
                    System.out.println("Insufficient balance!");
                }
                return;
            }
        }
        System.out.println("Account not found!");
    }

    public void checkBalance() {
        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                System.out.println("Account balance: " + account.getBalance());
                return;
            }
        }
        System.out.println("Account not found!");
    }

    public void displayAccounts() {
        for (Account account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber() + ", Account Holder Name: " + account.getAccountHolderName() + ", Balance: " + account.getBalance());
        }
    }

    public static void main(String[] args) {
        BankManagementSystem system = new BankManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check balance");
            System.out.println("5. Display accounts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    system.createAccount();
                    break;
                case 2:
                    system.deposit();
                    break;
                case 3:
                    system.withdraw();
                    break;
                case 4:
                    system.checkBalance();
                    break;
                case 5:
                    system.displayAccounts();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}