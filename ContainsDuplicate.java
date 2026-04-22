// LeetCode #217 - Contains Duplicate
// Return true if any value appears at least twice in the array.
// Time: O(n), Space: O(n)

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate sol = new ContainsDuplicate();
        System.out.println(sol.containsDuplicate(new int[]{1,2,3,1}));       // true
        System.out.println(sol.containsDuplicate(new int[]{1,2,3,4}));       // false
        System.out.println(sol.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2})); // true
    }
}
