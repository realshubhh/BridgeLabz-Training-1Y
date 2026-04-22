// Topic: Classes, Constructors, Polymorphism and Keyword Static
// Demonstrates all four concepts in one cohesive program

public class PolymorphismAndStatic {

    // Abstract base - polymorphism via method overriding
    static abstract class Payment {
        protected String recipient;
        protected double amount;
        private static int transactionCount = 0;  // static field
        private static double totalProcessed = 0; // static field

        Payment(String recipient, double amount) {
            this.recipient = recipient;
            this.amount    = amount;
        }

        // Static factory method
        static Payment of(String type, String recipient, double amount) {
            return switch (type.toLowerCase()) {
                case "upi"  -> new UPI(recipient, amount);
                case "card" -> new Card(recipient, amount, "VISA");
                case "cash" -> new Cash(recipient, amount);
                default -> throw new IllegalArgumentException("Unknown type: " + type);
            };
        }

        // Polymorphic method
        abstract String process();

        void execute() {
            String result = process();  // runtime polymorphism
            transactionCount++;
            totalProcessed += amount;
            System.out.println("[" + transactionCount + "] " + result);
        }

        // Static method
        static void printSummary() {
            System.out.println("Transactions: " + transactionCount +
                               " | Total: ₹" + totalProcessed);
        }
    }

    static class UPI extends Payment {
        UPI(String recipient, double amount) { super(recipient, amount); }

        @Override
        String process() {
            return "UPI: ₹" + amount + " sent to @" + recipient;
        }
    }

    static class Card extends Payment {
        private String cardType;

        Card(String recipient, double amount, String cardType) {
            super(recipient, amount);
            this.cardType = cardType;
        }

        @Override
        String process() {
            return cardType + " Card: ₹" + amount + " charged for " + recipient;
        }
    }

    static class Cash extends Payment {
        Cash(String recipient, double amount) { super(recipient, amount); }

        @Override
        String process() {
            return "Cash: ₹" + amount + " handed to " + recipient;
        }
    }

    // Constructor chaining demo
    static class Product {
        String name;
        double price;
        int    stock;

        Product()                          { this("Unknown", 0.0, 0); }
        Product(String name)               { this(name, 0.0, 0); }
        Product(String name, double price) { this(name, price, 100); }
        Product(String name, double price, int stock) {
            this.name  = name;
            this.price = price;
            this.stock = stock;
        }

        @Override public String toString() {
            return name + " | ₹" + price + " | Stock: " + stock;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Polymorphism via Factory + Overriding ===");
        Payment[] payments = {
            Payment.of("upi",  "merchant",   500),
            Payment.of("card", "Amazon",     1200),
            Payment.of("cash", "Shopkeeper", 250),
            Payment.of("upi",  "friend",     100)
        };

        for (Payment p : payments) p.execute();

        Payment.printSummary(); // static method call

        System.out.println("\n=== Constructor Chaining ===");
        System.out.println(new Product());
        System.out.println(new Product("Laptop"));
        System.out.println(new Product("Phone", 15000));
        System.out.println(new Product("Tablet", 20000, 50));
    }
}
