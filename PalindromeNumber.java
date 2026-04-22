// LeetCode #9 - Palindrome Number
// Determine whether an integer is a palindrome without converting to string.
// Time: O(log n), Space: O(1)

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        PalindromeNumber sol = new PalindromeNumber();
        System.out.println(sol.isPalindrome(121));   // true
        System.out.println(sol.isPalindrome(-121));  // false
        System.out.println(sol.isPalindrome(10));    // false
        System.out.println(sol.isPalindrome(1221));  // true
    }
}
