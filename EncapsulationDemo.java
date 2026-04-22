// Topic: Applying Encapsulation
// Demonstrates: Access modifiers (public/private/protected/default), getters/setters, data hiding

public class EncapsulationDemo {

    static class Employee {
        private int    id;       // private - only accessible within class
        private String name;
        private double salary;
        protected String department; // accessible within package and subclasses

        public Employee(int id, String name, double salary, String department) {
            this.id         = id;
            this.name       = name;
            this.department = department;
            setSalary(salary);  // use setter for validation
        }

        // Getters
        public int    getId()         { return id; }
        public String getName()       { return name; }
        public double getSalary()     { return salary; }
        public String getDepartment() { return department; }

        // Setter with validation
        public void setSalary(double salary) {
            if (salary < 0) {
                System.out.println("Invalid salary! Setting to 0.");
                this.salary = 0;
            } else {
                this.salary = salary;
            }
        }

        public void setName(String name) {
            if (name == null || name.isEmpty()) {
                System.out.println("Name cannot be empty!");
            } else {
                this.name = name;
            }
        }

        @Override
        public String toString() {
            return String.format("Employee[%d | %s | %s | $%.2f]", id, name, department, salary);
        }
    }

    static class Manager extends Employee {
        private int teamSize;

        Manager(int id, String name, double salary, int teamSize) {
            super(id, name, salary, "Management");
            this.teamSize = teamSize;
        }

        @Override
        public String toString() {
            // Can access protected 'department' directly
            return super.toString() + " | Team size: " + teamSize;
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee(101, "Alice", 75000, "Engineering");
        System.out.println(e);

        // Using setter with validation
        e.setSalary(-5000);  // triggers validation
        e.setSalary(80000);
        System.out.println("After raise: " + e);

        // Manager
        Manager m = new Manager(201, "Bob", 120000, 10);
        System.out.println(m);

        // Direct access to private field is NOT allowed:
        // e.salary = 99999;  // COMPILE ERROR - encapsulation in action
    }
}
