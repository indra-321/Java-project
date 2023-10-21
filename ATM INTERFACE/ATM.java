import java.util.Scanner;

// Bank Account Class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// ATM Class
class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void performTransaction(int choice, double amount) {
        switch (choice) {
            case 1:
                System.out.println("Balance: $" + account.getBalance());
                break;
            case 2:
                account.deposit(amount);
                System.out.println("Deposit of $" + amount + " successful.");
                break;
            case 3:
                if (account.withdraw(amount)) {
                    System.out.println("Withdrawal of $" + amount + " successful.");
                } else {
                    System.out.println("Insufficient funds.");
                }
                break;
            case 4:
                System.out.println("Exiting ATM. Thank you!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}

public class Mains {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial account balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBalance);

        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                atm.performTransaction(choice, 0); // Exit option
            } else if (choice == 1) {
                atm.performTransaction(choice, 0); // Check Balance
            } else {
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                if (amount <= 0) {
                    System.out.println("Invalid amount.");
                } else {
                    atm.performTransaction(choice, amount);
                }
            }
        }
    }
}