// LeetCode #242 - Valid Anagram
// Given two strings s and t, return true if t is an anagram of s.
// Time: O(n), Space: O(1) - 26 characters only

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) if (c != 0) return false;
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram sol = new ValidAnagram();
        System.out.println(sol.isAnagram("anagram", "nagaram")); // true
        System.out.println(sol.isAnagram("rat", "car"));         // false
        System.out.println(sol.isAnagram("listen", "silent"));   // true
        System.out.println(sol.isAnagram("hello", "bello"));     // false
    }
}
