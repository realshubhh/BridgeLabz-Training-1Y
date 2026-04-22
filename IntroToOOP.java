// Topic: Introduction to Object-Oriented Java Programming
// Demonstrates: Class, Object, Fields, Methods

public class IntroToOOP {

    // A simple class representing a bank account
    static class BankAccount {
        String owner;
        double balance;

        BankAccount(String owner, double initialBalance) {
            this.owner = owner;
            this.balance = initialBalance;
        }

        void deposit(double amount) {
            balance += amount;
            System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        }

        void withdraw(double amount) {
            if (amount > balance) {
                System.out.println("Insufficient funds!");
            } else {
                balance -= amount;
                System.out.println("Withdrawn: " + amount + " | New Balance: " + balance);
            }
        }

        void displayInfo() {
            System.out.println("Account Owner: " + owner + ", Balance: " + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Alice", 1000.0);
        acc.displayInfo();
        acc.deposit(500.0);
        acc.withdraw(200.0);
        acc.withdraw(2000.0);
    }
}
