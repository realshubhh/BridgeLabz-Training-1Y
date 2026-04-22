// Topic: Using Java Packages
// Demonstrates: Importing packages, static imports, java.util and java.lang

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.lang.Math.*;   // static import
import static java.lang.System.out;  // static import for out.println

public class JavaPackagesDemo {

    public static void main(String[] args) {
        // Using static import - no need for Math. prefix
        out.println("PI = " + PI);
        out.println("sqrt(144) = " + sqrt(144));
        out.println("pow(2,10) = " + pow(2, 10));
        out.println("abs(-42)  = " + abs(-42));

        // java.util.ArrayList
        List<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");
        Collections.sort(names);
        out.println("\nSorted names: " + names);

        // java.util.HashMap
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 88);
        scores.put("Charlie", 92);
        out.println("Scores map : " + scores);
        out.println("Alice score: " + scores.get("Alice"));
    }
}
