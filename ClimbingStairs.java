// LeetCode #70 - Climbing Stairs
// How many distinct ways to climb n stairs (1 or 2 steps at a time)?
// Time: O(n), Space: O(1)  - essentially Fibonacci

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 2) return n;
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        ClimbingStairs sol = new ClimbingStairs();
        System.out.println(sol.climbStairs(1));  // 1
        System.out.println(sol.climbStairs(2));  // 2
        System.out.println(sol.climbStairs(3));  // 3
        System.out.println(sol.climbStairs(5));  // 8
        System.out.println(sol.climbStairs(10)); // 89
    }
}
