// Topic: Exception Handling
// Demonstrates: Hierarchy, checked/unchecked/errors, try-catch-finally, throw/throws, custom exceptions

public class ExceptionHandlingDemo {

    // Custom checked exception
    static class InsufficientFundsException extends Exception {
        private double amount;
        InsufficientFundsException(double amount) {
            super("Insufficient funds! Shortfall: " + amount);
            this.amount = amount;
        }
        double getAmount() { return amount; }
    }

    // Custom unchecked exception
    static class InvalidAgeException extends RuntimeException {
        InvalidAgeException(String msg) { super(msg); }
    }

    // Method declaring checked exception
    static void withdraw(double balance, double amount) throws InsufficientFundsException {
        if (amount > balance) throw new InsufficientFundsException(amount - balance);
        System.out.println("Withdrawn: " + amount + " | Balance: " + (balance - amount));
    }

    static void validateAge(int age) {
        if (age < 0 || age > 150) throw new InvalidAgeException("Age out of range: " + age);
        System.out.println("Valid age: " + age);
    }

    static int divide(int a, int b) {
        return a / b;  // throws ArithmeticException if b == 0
    }

    public static void main(String[] args) {
        // Try-Catch-Finally
        System.out.println("=== ArithmeticException ===");
        try {
            int result = divide(10, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block always runs.");
        }

        // Custom checked exception
        System.out.println("\n=== Custom Checked Exception ===");
        try {
            withdraw(100.0, 50.0);   // ok
            withdraw(100.0, 200.0);  // throws
        } catch (InsufficientFundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // Custom unchecked exception
        System.out.println("\n=== Custom Unchecked Exception ===");
        try {
            validateAge(25);
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // NullPointerException
        System.out.println("\n=== NullPointerException ===");
        try {
            String s = null;
            s.length();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        }

        // ArrayIndexOutOfBounds
        System.out.println("\n=== ArrayIndexOutOfBoundsException ===");
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // Multi-catch
        System.out.println("\n=== Multi-Catch ===");
        try {
            Object obj = "hello";
            Integer num = (Integer) obj;  // ClassCastException
        } catch (ClassCastException | NumberFormatException e) {
            System.out.println("Multi-catch: " + e.getClass().getSimpleName());
        }
    }
}
