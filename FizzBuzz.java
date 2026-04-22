// LeetCode #412 - Fizz Buzz
// Return list of strings 1..n with "Fizz", "Buzz", "FizzBuzz" rules.
// Time: O(n), Space: O(n)

import java.util.*;

public class FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if      (i % 15 == 0) result.add("FizzBuzz");
            else if (i % 3  == 0) result.add("Fizz");
            else if (i % 5  == 0) result.add("Buzz");
            else                  result.add(String.valueOf(i));
        }
        return result;
    }

    // Extensible version using a map (easy to add new rules)
    public List<String> fizzBuzzExtensible(int n) {
        Map<Integer, String> rules = new LinkedHashMap<>();
        rules.put(3, "Fizz");
        rules.put(5, "Buzz");
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, String> entry : rules.entrySet()) {
                if (i % entry.getKey() == 0) sb.append(entry.getValue());
            }
            result.add(sb.length() > 0 ? sb.toString() : String.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        FizzBuzz sol = new FizzBuzz();
        System.out.println(sol.fizzBuzz(15));
        System.out.println(sol.fizzBuzzExtensible(15));
    }
}
