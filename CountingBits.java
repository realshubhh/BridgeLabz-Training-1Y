// LeetCode #338 - Counting Bits
// Return array ans of length n+1 where ans[i] = number of 1s in binary of i.
// Time: O(n), Space: O(n)  (DP approach)

import java.util.Arrays;

public class CountingBits {
    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i >> 1] + (i & 1); // dp[i] = dp[i/2] + last bit
        }
        return dp;
    }

    public static void main(String[] args) {
        CountingBits sol = new CountingBits();
        System.out.println(Arrays.toString(sol.countBits(2))); // [0,1,1]
        System.out.println(Arrays.toString(sol.countBits(5))); // [0,1,1,2,1,2]
        System.out.println(Arrays.toString(sol.countBits(8))); // [0,1,1,2,1,2,2,3,1]
    }
}
