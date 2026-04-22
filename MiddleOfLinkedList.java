// LeetCode #876 - Middle of the Linked List
// Find the middle node; if two middles, return the second.
// Time: O(n), Space: O(1) - fast/slow pointer

public class MiddleOfLinkedList {

    static class ListNode {
        int val; ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static ListNode build(int... vals) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int v : vals) { cur.next = new ListNode(v); cur = cur.next; }
        return dummy.next;
    }

    static String print(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) { sb.append(head.val); if (head.next != null) sb.append(","); head = head.next; }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        MiddleOfLinkedList sol = new MiddleOfLinkedList();
        System.out.println(print(sol.middleNode(build(1,2,3,4,5))));   // [3,4,5]
        System.out.println(print(sol.middleNode(build(1,2,3,4,5,6)))); // [4,5,6]
        System.out.println(print(sol.middleNode(build(1))));            // [1]
    }
}
