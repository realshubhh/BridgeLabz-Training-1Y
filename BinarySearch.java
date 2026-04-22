// LeetCode #704 - Binary Search
// Search for target in sorted array. Return index or -1.
// Time: O(log n), Space: O(1)

public class BinarySearch {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if      (nums[mid] == target) return mid;
            else if (nums[mid] <  target) lo = mid + 1;
            else                          hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch sol = new BinarySearch();
        System.out.println(sol.search(new int[]{-1,0,3,5,9,12}, 9));  // 4
        System.out.println(sol.search(new int[]{-1,0,3,5,9,12}, 2));  // -1
        System.out.println(sol.search(new int[]{5}, 5));               // 0
        System.out.println(sol.search(new int[]{1,3,5,7,9}, 7));      // 3
    }
}
