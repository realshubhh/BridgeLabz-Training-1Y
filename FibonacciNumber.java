// LeetCode #509 - Fibonacci Number
// Calculate F(n) = F(n-1) + F(n-2), with F(0)=0, F(1)=1.
// Multiple approaches shown: iterative O(n), matrix O(log n), memoised O(n)

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {

    // Iterative - O(n) time, O(1) space
    public int fib(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b; a = b; b = c;
        }
        return b;
    }

    // Memoisation - O(n) time, O(n) space
    private Map<Integer, Integer> memo = new HashMap<>();
    public int fibMemo(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        int result = fibMemo(n - 1) + fibMemo(n - 2);
        memo.put(n, result);
        return result;
    }

    // Recursive (naive) - O(2^n), only for small n
    public int fibNaive(int n) {
        if (n <= 1) return n;
        return fibNaive(n - 1) + fibNaive(n - 2);
    }

    public static void main(String[] args) {
        FibonacciNumber sol = new FibonacciNumber();
        int[] tests = {0, 1, 2, 5, 10, 20};
        System.out.println("n  | iter | memo | naive");
        System.out.println("-".repeat(30));
        for (int n : tests) {
            System.out.printf("%-3d| %-5d| %-5d| %d%n",
                n, sol.fib(n), sol.fibMemo(n), sol.fibNaive(n));
        }
    }
}
