// Topic: Creating and Using Methods
// Demonstrates: Method signatures, types, overloading, static vs non-static

public class MethodsDemo {

    // Static method - belongs to class, no object needed
    static int add(int a, int b) { return a + b; }

    // Method Overloading - same name, different parameters
    static double add(double a, double b) { return a + b; }
    static int add(int a, int b, int c) { return a + b + c; }
    static String add(String a, String b) { return a + b; }

    // Non-static method - belongs to instance
    String name;
    MethodsDemo(String name) { this.name = name; }

    void greet() {
        System.out.println("Hello from " + name);
    }

    // Recursive method
    static int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // Method with varargs
    static int sum(int... numbers) {
        int total = 0;
        for (int num : numbers) total += num;
        return total;
    }

    // Method returning value
    static String grade(int marks) {
        if (marks >= 90) return "A";
        if (marks >= 75) return "B";
        if (marks >= 60) return "C";
        return "F";
    }

    public static void main(String[] args) {
        // Static method calls
        System.out.println("add(2,3)        = " + add(2, 3));
        System.out.println("add(2.5,3.5)    = " + add(2.5, 3.5));
        System.out.println("add(1,2,3)      = " + add(1, 2, 3));
        System.out.println("add(Hi, World)  = " + add("Hi ", "World"));

        // Recursive
        System.out.println("factorial(5)    = " + factorial(5));

        // Varargs
        System.out.println("sum(1,2,3,4,5)  = " + sum(1, 2, 3, 4, 5));

        // Grade
        System.out.println("grade(85)       = " + grade(85));

        // Non-static
        MethodsDemo obj = new MethodsDemo("Alice");
        obj.greet();
    }
}
