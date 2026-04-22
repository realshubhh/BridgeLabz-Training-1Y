// Topic: Regular Expressions
// Demonstrates: Pattern, Matcher class, common regex patterns

import java.util.regex.*;
import java.util.*;

public class RegularExpressionsDemo {

    static boolean matches(String input, String regex) {
        return Pattern.matches(regex, input);
    }

    public static void main(String[] args) {
        // Basic matching
        System.out.println("=== Basic Pattern Matching ===");
        System.out.println("Email valid   : " + matches("user@example.com",
                           "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"));
        System.out.println("Phone valid   : " + matches("9876543210", "[6-9]\\d{9}"));
        System.out.println("Zip code      : " + matches("110001", "\\d{6}"));
        System.out.println("Digits only   : " + matches("12345", "\\d+"));
        System.out.println("Alpha only    : " + matches("Hello", "[a-zA-Z]+"));

        // Pattern + Matcher for find
        System.out.println("\n=== Pattern.compile + Matcher.find ===");
        String text = "Call us at 9876543210 or 8765432109 for support.";
        Pattern phonePattern = Pattern.compile("[6-9]\\d{9}");
        Matcher matcher = phonePattern.matcher(text);
        while (matcher.find()) {
            System.out.println("Found phone: " + matcher.group() + " at index " + matcher.start());
        }

        // Groups
        System.out.println("\n=== Capturing Groups ===");
        String date = "Today is 2025-08-15 and tomorrow is 2025-08-16.";
        Pattern datePattern = Pattern.compile("(\\d{4})-(\\d{2})-(\\d{2})");
        Matcher dateMatcher = datePattern.matcher(date);
        while (dateMatcher.find()) {
            System.out.println("Year: " + dateMatcher.group(1) +
                               ", Month: " + dateMatcher.group(2) +
                               ", Day: "   + dateMatcher.group(3));
        }

        // replaceAll
        System.out.println("\n=== Replace ===");
        String html = "<b>Hello</b> <i>World</i>";
        String stripped = html.replaceAll("<[^>]+>", "");
        System.out.println("Stripped HTML : " + stripped);

        String masked = "Call 9876543210 now".replaceAll("[6-9]\\d{9}", "**********");
        System.out.println("Masked phone  : " + masked);

        // split with regex
        System.out.println("\n=== Split with Regex ===");
        String csv = "Alice  ,  Bob,   Charlie ,Dave";
        String[] parts = csv.split("\\s*,\\s*");
        for (String part : parts) System.out.println("  '" + part.trim() + "'");

        // Password validation
        System.out.println("\n=== Password Strength ===");
        String[] passwords = {"abc", "Abc123", "Abc@1234", "password123"};
        Pattern strongPassword = Pattern.compile(
            "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$"
        );
        for (String pw : passwords) {
            System.out.println(pw + " -> " + (strongPassword.matcher(pw).matches() ? "STRONG" : "WEAK"));
        }
    }
}
