// LeetCode #53 - Maximum Subarray
// Find the contiguous subarray with the largest sum (Kadane's Algorithm).
// Time: O(n), Space: O(1)

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubarray sol = new MaximumSubarray();
        System.out.println(sol.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); // 6
        System.out.println(sol.maxSubArray(new int[]{1}));                      // 1
        System.out.println(sol.maxSubArray(new int[]{5,4,-1,7,8}));             // 23
        System.out.println(sol.maxSubArray(new int[]{-1,-2,-3,-4}));            // -1
    }
}
