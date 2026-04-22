// Topic: Accepting User Input in Java Programs
// Demonstrates: Scanner class for various input types

import java.util.Scanner;

public class UserInputScanner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        int age = sc.nextInt();

        System.out.print("Enter your GPA: ");
        double gpa = sc.nextDouble();

        System.out.println("\n--- Summary ---");
        System.out.println("Name : " + name);
        System.out.println("Age  : " + age);
        System.out.println("GPA  : " + gpa);

        if (gpa >= 3.5) {
            System.out.println("Status: Distinction");
        } else if (gpa >= 2.5) {
            System.out.println("Status: Pass");
        } else {
            System.out.println("Status: Needs Improvement");
        }

        sc.close();
    }
}
