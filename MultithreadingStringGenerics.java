// Topic: Inheritance, Multithreading, String Handling, Generic Classes
// Demonstrates all four topics in one integrated program

import java.util.ArrayList;
import java.util.List;

// Generic Stack class
class Stack<T> {
    private List<T> data = new ArrayList<>();

    public void push(T item)      { data.add(item); }
    public T    pop()             { return data.isEmpty() ? null : data.remove(data.size() - 1); }
    public T    peek()            { return data.isEmpty() ? null : data.get(data.size() - 1); }
    public boolean isEmpty()      { return data.isEmpty(); }
    public int  size()            { return data.size(); }
    @Override public String toString() { return data.toString(); }
}

// Inheritance chain
abstract class Worker extends Thread {
    protected String workerName;
    protected Stack<String> log = new Stack<>();

    Worker(String name) {
        this.workerName = name;
        setName(name);
    }

    abstract void doWork();

    @Override
    public void run() {
        log.push(workerName + " started");
        doWork();
        log.push(workerName + " finished");
        System.out.println("[LOG] " + log);
    }
}

class StringWorker extends Worker {
    private String sentence;

    StringWorker(String name, String sentence) {
        super(name);
        this.sentence = sentence;
    }

    @Override
    void doWork() {
        // String handling operations
        String[] words = sentence.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }

        int vowelCount = 0;
        for (char c : sentence.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) vowelCount++;
        }

        String result = String.format(
            "%s | Words=%d | Vowels=%d | Reversed='%s'",
            workerName, words.length, vowelCount, reversed.toString().trim()
        );
        log.push(result);
        System.out.println(result);

        try { Thread.sleep(100); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}

class CounterWorker extends Worker {
    private int limit;

    CounterWorker(String name, int limit) {
        super(name);
        this.limit = limit;
    }

    @Override
    void doWork() {
        for (int i = 1; i <= limit; i++) {
            log.push(workerName + "=" + i);
            try { Thread.sleep(50); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
        System.out.println(workerName + " counted to " + limit);
    }
}

public class MultithreadingStringGenerics {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Generic Stack ===");
        Stack<Integer> intStack = new Stack<>();
        intStack.push(10); intStack.push(20); intStack.push(30);
        System.out.println("Stack: " + intStack);
        System.out.println("Pop: "  + intStack.pop());
        System.out.println("Peek: " + intStack.peek());

        Stack<String> strStack = new Stack<>();
        strStack.push("Hello"); strStack.push("World");
        System.out.println("String stack: " + strStack);

        System.out.println("\n=== Multithreaded String Workers ===");
        Worker w1 = new StringWorker("W1", "Java is a powerful programming language");
        Worker w2 = new StringWorker("W2", "Multithreading makes programs concurrent");
        Worker w3 = new CounterWorker("Counter", 4);

        w1.start();
        w2.start();
        w3.start();

        w1.join();
        w2.join();
        w3.join();

        System.out.println("\nAll workers completed.");
    }
}
