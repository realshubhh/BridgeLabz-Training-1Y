// Topic: The String API
// Demonstrates: String methods, StringTokenizer, StringBuilder, StringBuffer

import java.util.StringTokenizer;

public class StringAPIDemo {

    public static void main(String[] args) {
        // --- Common String Methods ---
        System.out.println("=== String Methods ===");
        String s = "  Hello, Java World!  ";
        System.out.println("Original      : '" + s + "'");
        System.out.println("trim()        : '" + s.trim() + "'");
        System.out.println("toLowerCase() : " + s.trim().toLowerCase());
        System.out.println("toUpperCase() : " + s.trim().toUpperCase());
        System.out.println("length()      : " + s.length());
        System.out.println("charAt(7)     : " + s.trim().charAt(7));
        System.out.println("indexOf('J')  : " + s.indexOf('J'));
        System.out.println("substring(2,7): " + s.trim().substring(0, 5));
        System.out.println("replace       : " + s.trim().replace("Java", "Python"));
        System.out.println("contains      : " + s.contains("World"));
        System.out.println("startsWith    : " + s.trim().startsWith("Hello"));
        System.out.println("split result  : ");
        for (String part : s.trim().split(" ")) System.out.println("  '" + part + "'");

        // --- StringTokenizer ---
        System.out.println("\n=== StringTokenizer ===");
        String csv = "Alice,Bob,Charlie,David";
        StringTokenizer st = new StringTokenizer(csv, ",");
        while (st.hasMoreTokens()) System.out.println("Token: " + st.nextToken());

        // --- StringBuilder (not thread-safe, faster) ---
        System.out.println("\n=== StringBuilder ===");
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(5, ",");
        sb.replace(0, 5, "Hi");
        sb.reverse();
        System.out.println("StringBuilder result: " + sb);

        // --- StringBuffer (thread-safe) ---
        System.out.println("\n=== StringBuffer ===");
        StringBuffer sbuf = new StringBuffer();
        sbuf.append("Java");
        sbuf.append(" is ");
        sbuf.append("powerful");
        System.out.println("StringBuffer result: " + sbuf);
        System.out.println("Capacity: " + sbuf.capacity());

        // String immutability
        System.out.println("\n=== String Immutability ===");
        String a = "Java";
        String b = a.concat(" Programming");
        System.out.println("a unchanged: " + a);
        System.out.println("b new ref  : " + b);
    }
}
