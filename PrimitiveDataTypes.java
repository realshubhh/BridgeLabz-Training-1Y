// Topic: Working with Java Primitive Data Types
// Demonstrates: All primitive types, var keyword, scope of variables

public class PrimitiveDataTypes {

    static int classLevel = 100;  // class-level scope

    public static void main(String[] args) {
        // All 8 primitive types
        byte   b  = 127;
        short  s  = 32000;
        int    i  = 2147483647;
        long   l  = 9_223_372_036_854_775_807L;
        float  f  = 3.14f;
        double d  = 3.141592653589793;
        char   c  = 'A';
        boolean flag = true;

        System.out.println("byte    : " + b);
        System.out.println("short   : " + s);
        System.out.println("int     : " + i);
        System.out.println("long    : " + l);
        System.out.println("float   : " + f);
        System.out.println("double  : " + d);
        System.out.println("char    : " + c);
        System.out.println("boolean : " + flag);

        // The 'var' keyword (Java 10+) - type inferred at compile time
        var name    = "Java";     // inferred as String
        var version = 17;         // inferred as int
        var pi      = 3.14159;    // inferred as double
        System.out.println("\nvar demo -> " + name + " " + version + " pi=" + pi);

        // Scope demonstration
        {
            int blockScoped = 42;  // only visible inside this block
            System.out.println("Inside block: " + blockScoped);
        }
        // System.out.println(blockScoped);  // ERROR: out of scope

        System.out.println("Class-level variable: " + classLevel);
    }
}
