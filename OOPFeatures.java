// Topic: Object-Oriented Programming - Features of OOP
// Demonstrates: Encapsulation, Inheritance, Polymorphism, Abstraction

abstract class Animal {
    private String name;  // Encapsulation

    public Animal(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public abstract String sound(); // Abstraction

    @Override
    public String toString() {
        return name + " says " + sound();
    }
}

class Dog extends Animal {  // Inheritance
    public Dog(String name) { super(name); }

    @Override
    public String sound() { return "Woof"; }  // Polymorphism
}

class Cat extends Animal {
    public Cat(String name) { super(name); }

    @Override
    public String sound() { return "Meow"; }
}

public class OOPFeatures {
    public static void main(String[] args) {
        Animal[] animals = { new Dog("Buddy"), new Cat("Whiskers") };
        for (Animal a : animals) {
            System.out.println(a);  // Polymorphic call
        }
    }
}
