// Topic: Java Technology & Environment
// Demonstrates: Structure of a simple Java program, JVM/JDK/JRE concepts via comments

/**
 * JVM  - Java Virtual Machine: Executes Java bytecode (.class files)
 * JRE  - Java Runtime Environment: JVM + standard libraries (for running Java apps)
 * JDK  - Java Development Kit: JRE + compiler (javac) + tools (for developing Java apps)
 *
 * Compilation process:
 *   Source Code (.java) --[javac]--> Bytecode (.class) --[JVM]--> Machine Execution
 *
 * Key Features of Java:
 * - Platform Independent (Write Once, Run Anywhere)
 * - Object-Oriented
 * - Strongly Typed
 * - Automatic Garbage Collection
 * - Multithreaded
 * - Secure
 */
public class JVMJDKJREDemo {

    public static void main(String[] args) {
        // Runtime info about the JVM
        System.out.println("Java Version  : " + System.getProperty("java.version"));
        System.out.println("JVM Name      : " + System.getProperty("java.vm.name"));
        System.out.println("OS Name       : " + System.getProperty("os.name"));
        System.out.println("User Home     : " + System.getProperty("user.home"));

        // Demonstrating platform independence
        System.out.println("\nThis bytecode runs on any platform with a JVM installed!");
    }
}
