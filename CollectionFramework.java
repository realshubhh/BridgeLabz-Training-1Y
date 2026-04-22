// Topic: Implementation of Collection Framework
// Demonstrates: List, Set, Map, Queue, Stack, PriorityQueue, Iterator

import java.util.*;

public class CollectionFramework {

    public static void main(String[] args) {

        // ---- ArrayList ----
        System.out.println("=== ArrayList ===");
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 9));
        Collections.sort(arrayList);
        System.out.println("Sorted: " + arrayList);
        arrayList.removeIf(n -> n % 2 == 0);
        System.out.println("Odds only: " + arrayList);

        // ---- LinkedList ----
        System.out.println("\n=== LinkedList ===");
        LinkedList<String> linkedList = new LinkedList<>(Arrays.asList("B", "C", "D"));
        linkedList.addFirst("A");
        linkedList.addLast("E");
        System.out.println("LinkedList: " + linkedList);
        System.out.println("Remove first: " + linkedList.removeFirst());

        // ---- Stack ----
        System.out.println("\n=== Stack ===");
        Stack<String> stack = new Stack<>();
        stack.push("First"); stack.push("Second"); stack.push("Third");
        System.out.println("Peek: " + stack.peek());
        while (!stack.isEmpty()) System.out.println("Pop: " + stack.pop());

        // ---- Queue (LinkedList) ----
        System.out.println("\n=== Queue ===");
        Queue<String> queue = new LinkedList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        queue.offer("Diana");
        System.out.println("Front: " + queue.peek());
        while (!queue.isEmpty()) System.out.println("Dequeue: " + queue.poll());

        // ---- PriorityQueue ----
        System.out.println("\n=== PriorityQueue (min-heap) ===");
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(10, 5, 8, 1, 3));
        while (!pq.isEmpty()) System.out.print(pq.poll() + " ");
        System.out.println();

        // ---- HashSet / LinkedHashSet / TreeSet ----
        System.out.println("\n=== HashSet ===");
        Set<String> hashSet = new HashSet<>(Arrays.asList("Banana", "Apple", "Cherry", "Apple"));
        System.out.println("HashSet: " + hashSet);

        System.out.println("\n=== LinkedHashSet (insertion order) ===");
        Set<String> linkedSet = new LinkedHashSet<>(Arrays.asList("Banana", "Apple", "Cherry"));
        System.out.println("LinkedHashSet: " + linkedSet);

        System.out.println("\n=== TreeSet (sorted) ===");
        Set<String> treeSet = new TreeSet<>(linkedSet);
        System.out.println("TreeSet: " + treeSet);

        // ---- HashMap / LinkedHashMap / TreeMap ----
        System.out.println("\n=== HashMap ===");
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("c", 3); hashMap.put("a", 1); hashMap.put("b", 2);
        System.out.println("HashMap: " + hashMap);

        System.out.println("\n=== TreeMap (sorted by key) ===");
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("TreeMap: " + treeMap);

        // ---- Iterator ----
        System.out.println("\n=== Iterator ===");
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Iterator<Integer> it = nums.iterator();
        while (it.hasNext()) {
            int val = it.next();
            if (val % 2 == 0) it.remove();  // safe removal
        }
        System.out.println("After removing evens: " + nums);

        // ---- Collections utility methods ----
        System.out.println("\n=== Collections Utility ===");
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6));
        System.out.println("Max      : " + Collections.max(list));
        System.out.println("Min      : " + Collections.min(list));
        System.out.println("Frequency(1): " + Collections.frequency(list, 1));
        Collections.reverse(list);
        System.out.println("Reversed : " + list);
        Collections.shuffle(list, new Random(42));
        System.out.println("Shuffled : " + list);
    }
}
