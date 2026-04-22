// Topic: Reusing Implementations using Inheritance
// Demonstrates: Subclass/Superclass, abstract extend, polymorphism, overriding vs overloading vs hiding

public class InheritanceDemo {

    static abstract class Shape {
        String color;
        Shape(String color) { this.color = color; }
        abstract double area();
        void display() { System.out.println(color + " shape, area = " + String.format("%.2f", area())); }
    }

    static class Rectangle extends Shape {
        double width, height;
        Rectangle(String color, double w, double h) { super(color); this.width = w; this.height = h; }

        @Override
        public double area() { return width * height; }

        // Overloading (same class, different params)
        double area(double scale) { return width * height * scale; }
    }

    static class Square extends Rectangle {
        Square(String color, double side) { super(color, side, side); }

        @Override
        public double area() { return width * width; }  // Overriding
    }

    static class Triangle extends Shape {
        double base, height;
        Triangle(String c, double b, double h) { super(c); this.base = b; this.height = h; }

        @Override
        public double area() { return 0.5 * base * height; }
    }

    // Static method hiding (not overriding)
    static class Parent {
        static void staticMethod() { System.out.println("Parent.staticMethod"); }
        void instanceMethod()      { System.out.println("Parent.instanceMethod"); }
    }

    static class Child extends Parent {
        static void staticMethod() { System.out.println("Child.staticMethod"); }  // HIDING
        @Override
        void instanceMethod()      { System.out.println("Child.instanceMethod"); } // OVERRIDING
    }

    public static void main(String[] args) {
        Shape[] shapes = {
            new Rectangle("Red", 4, 5),
            new Square("Blue", 3),
            new Triangle("Green", 6, 4)
        };

        // Polymorphism at runtime
        for (Shape s : shapes) s.display();

        // Overloading
        Rectangle r = new Rectangle("Yellow", 3, 4);
        System.out.println("Scaled area: " + r.area(2.0));

        // Hiding vs Overriding
        Parent obj = new Child();
        obj.instanceMethod();      // OVERRIDING -> Child's method
        Parent.staticMethod();     // HIDING     -> Parent's method (based on reference type)
        Child.staticMethod();      // Child's static method
    }
}
