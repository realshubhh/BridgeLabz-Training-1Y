// LeetCode #169 - Majority Element
// Find element that appears more than n/2 times (Boyer-Moore Voting Algorithm).
// Time: O(n), Space: O(1)

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int candidate = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public static void main(String[] args) {
        MajorityElement sol = new MajorityElement();
        System.out.println(sol.majorityElement(new int[]{3,2,3}));           // 3
        System.out.println(sol.majorityElement(new int[]{2,2,1,1,1,2,2}));  // 2
        System.out.println(sol.majorityElement(new int[]{6,5,5}));           // 5
    }
}
