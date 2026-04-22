// LeetCode #125 - Valid Palindrome
// A phrase is a palindrome if, after converting to lowercase and removing
// non-alphanumeric chars, it reads same forwards and backwards.
// Time: O(n), Space: O(1)

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            while (lo < hi && !Character.isLetterOrDigit(s.charAt(lo))) lo++;
            while (lo < hi && !Character.isLetterOrDigit(s.charAt(hi))) hi--;
            if (Character.toLowerCase(s.charAt(lo)) !=
                Character.toLowerCase(s.charAt(hi))) return false;
            lo++;
            hi--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(sol.isPalindrome("race a car"));                      // false
        System.out.println(sol.isPalindrome(" "));                               // true
        System.out.println(sol.isPalindrome("0P"));                              // false
    }
}
