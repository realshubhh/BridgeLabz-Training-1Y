// LeetCode #278 - First Bad Version
// Find the first bad version using binary search (minimise API calls).
// Time: O(log n), Space: O(1)

public class FirstBadVersion {

    private int badVersion; // simulates the bad version set by API

    // API provided (simulated)
    boolean isBadVersion(int version) {
        return version >= badVersion;
    }

    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) hi = mid;
            else                   lo = mid + 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        FirstBadVersion sol = new FirstBadVersion();

        sol.badVersion = 4;
        System.out.println("First bad (n=5, bad=4): " + sol.firstBadVersion(5)); // 4

        sol.badVersion = 1;
        System.out.println("First bad (n=1, bad=1): " + sol.firstBadVersion(1)); // 1

        sol.badVersion = 6;
        System.out.println("First bad (n=10, bad=6): " + sol.firstBadVersion(10)); // 6
    }
}
