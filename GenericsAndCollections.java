// Topic: Generics & Collections
// Demonstrates: Generic classes, generic methods, wildcards, diamond notation,
//               Collection hierarchy, Lists, Sets, Maps

import java.util.*;

// Generic class
class Pair<A, B> {
    private A first;
    private B second;

    Pair(A first, B second) {
        this.first  = first;
        this.second = second;
    }

    public A getFirst()  { return first; }
    public B getSecond() { return second; }

    @Override
    public String toString() { return "(" + first + ", " + second + ")"; }
}

// Generic method
class Utils {
    static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) >= 0 ? a : b;
    }

    // Wildcard - accepts List of any type
    static void printList(List<?> list) {
        for (Object o : list) System.out.print(o + " ");
        System.out.println();
    }

    // Upper bounded wildcard
    static double sumList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) sum += n.doubleValue();
        return sum;
    }
}

public class GenericsAndCollections {

    public static void main(String[] args) {
        // Generic class with diamond notation
        Pair<String, Integer> p = new Pair<>("Age", 25);
        System.out.println("Pair: " + p);

        // Generic method
        System.out.println("max(10,20)    = " + Utils.max(10, 20));
        System.out.println("max(\"A\",\"Z\") = " + Utils.max("A", "Z"));

        // === LIST ===
        System.out.println("\n=== ArrayList ===");
        List<String> names = new ArrayList<>(Arrays.asList("Charlie", "Alice", "Bob"));
        Collections.sort(names);
        System.out.println("Sorted : " + names);
        names.add(1, "Dave");
        names.remove("Charlie");
        System.out.println("After edit: " + names);
        Utils.printList(names);

        System.out.println("\n=== LinkedList as Deque ===");
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(0);
        System.out.println("Deque: " + deque);
        System.out.println("Poll first: " + deque.pollFirst());

        // === SET ===
        System.out.println("\n=== HashSet (no duplicates) ===");
        Set<Integer> set = new HashSet<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5));
        System.out.println("Set: " + set);

        System.out.println("\n=== TreeSet (sorted) ===");
        Set<Integer> treeSet = new TreeSet<>(set);
        System.out.println("TreeSet: " + treeSet);

        // === MAP ===
        System.out.println("\n=== HashMap ===");
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 88);
        scores.put("Charlie", 92);
        scores.put("Alice", 97);  // updates existing key
        System.out.println("Map: " + scores);
        System.out.println("Alice: " + scores.get("Alice"));
        scores.getOrDefault("Dave", 0);

        System.out.println("\n=== TreeMap (sorted by key) ===");
        Map<String, Integer> treeMap = new TreeMap<>(scores);
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        // Wildcard sum
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
        System.out.println("\nSum of doubles: " + Utils.sumList(doubles));
    }
}
