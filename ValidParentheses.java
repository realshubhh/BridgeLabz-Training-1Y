// LeetCode #20 - Valid Parentheses
// Given a string s with '(', ')', '{', '}', '[', ']',
// determine if the input string is valid.
// Time: O(n), Space: O(n)

import java.util.*;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();
        System.out.println(sol.isValid("()"));       // true
        System.out.println(sol.isValid("()[]{}"));   // true
        System.out.println(sol.isValid("(]"));       // false
        System.out.println(sol.isValid("{[()]}"));   // true
        System.out.println(sol.isValid("([)]"));     // false
    }
}
