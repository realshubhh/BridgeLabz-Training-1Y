// Topic: Programming Constructs
// Demonstrates: Sequence, Selection (if/switch), Iteration (for/while/do-while), Transfer (break/continue/return), For-Each

public class ProgrammingConstructs {

    public static void main(String[] args) {
        // --- SEQUENCE ---
        System.out.println("=== Sequence ===");
        int x = 10, y = 20;
        int sum = x + y;
        System.out.println(x + " + " + y + " = " + sum);

        // --- SELECTION ---
        System.out.println("\n=== Selection (if-else) ===");
        int marks = 75;
        if (marks >= 90)       System.out.println("Grade: A");
        else if (marks >= 75)  System.out.println("Grade: B");
        else if (marks >= 60)  System.out.println("Grade: C");
        else                   System.out.println("Grade: F");

        System.out.println("\n=== Selection (switch) ===");
        int day = 3;
        switch (day) {
            case 1: System.out.println("Monday"); break;
            case 2: System.out.println("Tuesday"); break;
            case 3: System.out.println("Wednesday"); break;
            default: System.out.println("Other day");
        }

        // --- ITERATION ---
        System.out.println("\n=== Iteration (for) ===");
        for (int i = 1; i <= 5; i++) System.out.print(i + " ");
        System.out.println();

        System.out.println("\n=== Iteration (while) ===");
        int n = 1;
        while (n <= 5) { System.out.print(n++ + " "); }
        System.out.println();

        System.out.println("\n=== Iteration (do-while) ===");
        int k = 1;
        do { System.out.print(k++ + " "); } while (k <= 5);
        System.out.println();

        // --- TRANSFER STATEMENTS ---
        System.out.println("\n=== Break & Continue ===");
        for (int i = 1; i <= 10; i++) {
            if (i == 6) break;
            if (i % 2 == 0) continue;
            System.out.print(i + " ");
        }
        System.out.println();

        // --- FOR-EACH LOOP ---
        System.out.println("\n=== For-Each Loop ===");
        String[] fruits = {"Apple", "Banana", "Cherry", "Mango"};
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }
    }
}
