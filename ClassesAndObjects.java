// Topic: Describing and Using Objects & Classes
// Demonstrates: Class structure, fields, methods, constructors, overloading, this/super, lifecycle

public class ClassesAndObjects {

    // A class representing a Student
    static class Student {
        // Fields (instance variables)
        private String name;
        private int age;
        private double gpa;
        private static int count = 0;  // class variable

        // Default constructor
        Student() {
            this("Unknown", 0, 0.0);  // constructor chaining using this()
        }

        // Parameterized constructor
        Student(String name, int age, double gpa) {
            this.name = name;
            this.age  = age;
            this.gpa  = gpa;
            count++;
        }

        // Overloaded constructor
        Student(String name) {
            this(name, 18, 0.0);
        }

        // Getters & Setters
        public String getName() { return name; }
        public int    getAge()  { return age; }
        public double getGpa()  { return gpa; }
        public void   setGpa(double gpa) { this.gpa = gpa; }

        public static int getCount() { return count; }

        @Override
        public String toString() {
            return "Student{name='" + name + "', age=" + age + ", gpa=" + gpa + "}";
        }
    }

    // Subclass
    static class GradStudent extends Student {
        private String thesis;

        GradStudent(String name, int age, double gpa, String thesis) {
            super(name, age, gpa);  // super() call
            this.thesis = thesis;
        }

        @Override
        public String toString() {
            return super.toString() + ", thesis='" + thesis + "'";
        }
    }

    public static void main(String[] args) {
        // Object creation
        Student s1 = new Student("Alice", 20, 3.8);
        Student s2 = new Student("Bob");
        Student s3 = new Student();
        GradStudent gs = new GradStudent("Carol", 25, 3.9, "AI in Healthcare");

        // Using objects
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(gs);

        // Modifying state
        s2.setGpa(3.5);
        System.out.println("Updated: " + s2);

        // Static field
        System.out.println("Total students: " + Student.getCount());

        // Dereferencing (GC eligible after this)
        s3 = null;
        System.gc();  // suggests GC
        System.out.println("s3 set to null (eligible for GC)");
    }
}
