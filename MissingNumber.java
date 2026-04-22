// LeetCode #268 - Missing Number
// Given array containing n distinct numbers in range [0, n], find the missing one.
// Time: O(n), Space: O(1)

public class MissingNumber {

    // Approach 1: Gauss sum formula
    public int missingNumber(int[] nums) {
        int n         = nums.length;
        int expected  = n * (n + 1) / 2;
        int actual    = 0;
        for (int num : nums) actual += num;
        return expected - actual;
    }

    // Approach 2: XOR
    public int missingNumberXOR(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }

    public static void main(String[] args) {
        MissingNumber sol = new MissingNumber();
        System.out.println(sol.missingNumber(new int[]{3,0,1}));         // 2
        System.out.println(sol.missingNumber(new int[]{0,1}));           // 2
        System.out.println(sol.missingNumber(new int[]{9,6,4,2,3,5,7,0,1})); // 8

        System.out.println(sol.missingNumberXOR(new int[]{3,0,1}));     // 2
        System.out.println(sol.missingNumberXOR(new int[]{0,1}));       // 2
    }
}
