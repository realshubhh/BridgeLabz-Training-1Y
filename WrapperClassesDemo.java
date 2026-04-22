// Topic: Using Wrapper Classes
// Demonstrates: Wrapper classes, Boxing, Unboxing, Auto-boxing, Auto-unboxing

import java.util.ArrayList;

public class WrapperClassesDemo {

    public static void main(String[] args) {
        // Manual Boxing (primitive -> object)
        Integer boxed = Integer.valueOf(42);
        Double  dbox  = Double.valueOf(3.14);
        System.out.println("Manual Boxing: " + boxed + ", " + dbox);

        // Manual Unboxing (object -> primitive)
        int    unboxed = boxed.intValue();
        double dunbox  = dbox.doubleValue();
        System.out.println("Manual Unboxing: " + unboxed + ", " + dunbox);

        // Auto-boxing (Java does it automatically)
        Integer autoBoxed = 100;   // compiler: Integer.valueOf(100)
        int     autoUnboxed = autoBoxed;  // compiler: autoBoxed.intValue()
        System.out.println("Auto-Boxing  : " + autoBoxed);
        System.out.println("Auto-Unboxing: " + autoUnboxed);

        // Wrapper utility methods
        System.out.println("\n=== Utility Methods ===");
        System.out.println("parseInt     : " + Integer.parseInt("255"));
        System.out.println("toBinaryString: " + Integer.toBinaryString(255));
        System.out.println("toHexString  : " + Integer.toHexString(255));
        System.out.println("toOctalString: " + Integer.toOctalString(255));
        System.out.println("MAX_VALUE    : " + Integer.MAX_VALUE);
        System.out.println("MIN_VALUE    : " + Integer.MIN_VALUE);
        System.out.println("isDigit('5') : " + Character.isDigit('5'));
        System.out.println("isLetter('a'): " + Character.isLetter('a'));
        System.out.println("toUpperCase  : " + Character.toUpperCase('a'));

        // ArrayList requires wrapper types (not primitives)
        System.out.println("\n=== Wrapper in Collections ===");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);  // auto-boxing
        list.add(20);
        list.add(30);
        int sum = 0;
        for (int val : list) sum += val;  // auto-unboxing
        System.out.println("List: " + list + ", Sum: " + sum);

        // Null unboxing - NullPointerException risk
        System.out.println("\n=== Null Unboxing Risk ===");
        try {
            Integer nullInt = null;
            int val = nullInt;  // NullPointerException!
        } catch (NullPointerException e) {
            System.out.println("Caught: NullPointerException during unboxing null");
        }
    }
}
