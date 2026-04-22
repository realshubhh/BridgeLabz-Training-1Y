// LeetCode #1480 - Running Sum of 1D Array
// Return runningSum where runningSum[i] = sum(nums[0..i]).
// Time: O(n), Space: O(1) in-place

import java.util.Arrays;

public class RunningSumArray {

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    // Without modifying input
    public int[] runningSumCopy(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] + nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        RunningSumArray sol = new RunningSumArray();
        System.out.println(Arrays.toString(sol.runningSum(new int[]{1,2,3,4})));       // [1,3,6,10]
        System.out.println(Arrays.toString(sol.runningSum(new int[]{1,1,1,1,1})));     // [1,2,3,4,5]
        System.out.println(Arrays.toString(sol.runningSumCopy(new int[]{3,1,2,10,1}))); // [3,4,6,16,17]
    }
}
