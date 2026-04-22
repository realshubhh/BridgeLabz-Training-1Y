// LeetCode #383 - Ransom Note
// Return true if the ransomNote can be constructed using the letters from magazine.
// Time: O(m+n), Space: O(1)

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        for (char c : magazine.toCharArray())   freq[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            if (--freq[c - 'a'] < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        RansomNote sol = new RansomNote();
        System.out.println(sol.canConstruct("a",  "b"));       // false
        System.out.println(sol.canConstruct("aa", "ab"));      // false
        System.out.println(sol.canConstruct("aa", "aab"));     // true
        System.out.println(sol.canConstruct("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj")); // true
    }
}
