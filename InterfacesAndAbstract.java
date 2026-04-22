// Topic: Programming Abstractly Through Interfaces
// Demonstrates: Interface, abstract class, default/private methods, Marker, Functional Interface, Lambda

import java.util.Arrays;
import java.util.List;

// Marker Interface (no methods)
interface Serializable {}

// Functional Interface (exactly one abstract method)
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

// Interface with default and private methods
interface Shape {
    double area();
    double perimeter();

    default String describe() {
        return String.format("Area=%.2f, Perimeter=%.2f", area(), perimeter());
    }

    private void validate(double value) {
        if (value <= 0) throw new IllegalArgumentException("Value must be positive");
    }
}

// Abstract class
abstract class Vehicle {
    protected String brand;
    Vehicle(String brand) { this.brand = brand; }
    abstract void start();  // must be implemented by subclass
    void stop() { System.out.println(brand + " stopped."); }
}

// Concrete class implementing interface
class Circle implements Shape, Serializable {
    private double radius;
    Circle(double r) { this.radius = r; }

    @Override public double area()      { return Math.PI * radius * radius; }
    @Override public double perimeter() { return 2 * Math.PI * radius; }
}

// Concrete class extending abstract class
class Car extends Vehicle {
    Car(String brand) { super(brand); }

    @Override
    public void start() { System.out.println(brand + " engine started!"); }
}

public class InterfacesAndAbstract {
    public static void main(String[] args) {
        // Interface
        Shape circle = new Circle(5);
        System.out.println("Circle -> " + circle.describe());

        // Marker interface check
        System.out.println("Is Serializable: " + (circle instanceof Serializable));

        // Abstract class
        Vehicle car = new Car("Toyota");
        car.start();
        car.stop();

        // Lambda with Functional Interface
        MathOperation add      = (a, b) -> a + b;
        MathOperation multiply = (a, b) -> a * b;
        MathOperation power    = (a, b) -> (int) Math.pow(a, b);

        System.out.println("Lambda add(5,3)      = " + add.operate(5, 3));
        System.out.println("Lambda multiply(5,3) = " + multiply.operate(5, 3));
        System.out.println("Lambda power(2,8)    = " + power.operate(2, 8));

        // Lambda with built-in functional interfaces
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        names.stream()
             .sorted()
             .forEach(n -> System.out.println("Name: " + n));
    }
}
