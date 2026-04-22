// Topic: Threads in Java
// Demonstrates: Thread lifecycle, Runnable interface, Thread class, sleep(), priorities

public class ThreadsDemo {

    // Method 1: Implementing Runnable
    static class CounterRunnable implements Runnable {
        private String name;
        private int limit;

        CounterRunnable(String name, int limit) {
            this.name  = name;
            this.limit = limit;
        }

        @Override
        public void run() {
            for (int i = 1; i <= limit; i++) {
                System.out.println(name + " : " + i);
                try {
                    Thread.sleep(100);  // pause for 100ms
                } catch (InterruptedException e) {
                    System.out.println(name + " interrupted");
                    return;
                }
            }
        }
    }

    // Method 2: Extending Thread class
    static class PrinterThread extends Thread {
        private String message;

        PrinterThread(String message, int priority) {
            this.message = message;
            setPriority(priority);
        }

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                System.out.println("[Priority " + getPriority() + "] " + message);
                try { Thread.sleep(50); } catch (InterruptedException e) { /* ignore */ }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Runnable Interface ===");
        Thread t1 = new Thread(new CounterRunnable("Thread-A", 3));
        Thread t2 = new Thread(new CounterRunnable("Thread-B", 3));

        t1.start();
        t2.start();
        t1.join();  // wait for t1 to complete
        t2.join();

        System.out.println("\n=== Thread Priorities ===");
        PrinterThread high = new PrinterThread("HIGH priority task",   Thread.MAX_PRIORITY);
        PrinterThread low  = new PrinterThread("LOW priority task",    Thread.MIN_PRIORITY);
        PrinterThread norm = new PrinterThread("NORMAL priority task", Thread.NORM_PRIORITY);

        high.start();
        low.start();
        norm.start();
        high.join();
        low.join();
        norm.join();

        System.out.println("\n=== Lambda Thread ===");
        Thread lambdaThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Lambda thread: " + i);
            }
        });
        lambdaThread.start();
        lambdaThread.join();

        System.out.println("Main thread finished.");
    }
}
