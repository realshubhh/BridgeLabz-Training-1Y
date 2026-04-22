// LeetCode #409 - Longest Palindrome
// Given a string s, return the length of the longest palindrome that can be built.
// Time: O(n), Space: O(1)

import java.util.HashSet;
import java.util.Set;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Set<Character> seen = new HashSet<>();
        int length = 0;
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                length += 2;
                seen.remove(c);
            } else {
                seen.add(c);
            }
        }
        if (!seen.isEmpty()) length++; // one odd character can go in the middle
        return length;
    }

    public static void main(String[] args) {
        LongestPalindrome sol = new LongestPalindrome();
        System.out.println(sol.longestPalindrome("abccccdd")); // 7 (e.g. "dccaccd")
        System.out.println(sol.longestPalindrome("a"));        // 1
        System.out.println(sol.longestPalindrome("aabb"));     // 4
        System.out.println(sol.longestPalindrome("ccc"));      // 3
    }
}
