// LeetCode #344 - Reverse String
// Reverse a character array in-place using two pointers.
// Time: O(n), Space: O(1)

import java.util.Arrays;

public class ReverseString {

    public void reverseString(char[] s) {
        int lo = 0, hi = s.length - 1;
        while (lo < hi) {
            char tmp = s[lo];
            s[lo++]  = s[hi];
            s[hi--]  = tmp;
        }
    }

    // Bonus: reverse words in a sentence
    public String reverseWords(String sentence) {
        String[] words = sentence.trim().split("\\s+");
        int lo = 0, hi = words.length - 1;
        while (lo < hi) {
            String tmp = words[lo];
            words[lo++] = words[hi];
            words[hi--] = tmp;
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        ReverseString sol = new ReverseString();

        char[] s1 = {'h','e','l','l','o'};
        sol.reverseString(s1);
        System.out.println("Reversed char[]: " + Arrays.toString(s1)); // [o,l,l,e,h]

        char[] s2 = {'H','a','n','n','a','h'};
        sol.reverseString(s2);
        System.out.println("Reversed char[]: " + Arrays.toString(s2)); // [h,a,n,n,a,H]

        System.out.println(sol.reverseWords("the sky is blue")); // blue is sky the
        System.out.println(sol.reverseWords("  hello world  ")); // world hello
    }
}
