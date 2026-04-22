// LeetCode #141 - Linked List Cycle
// Detect if a linked list has a cycle using Floyd's two-pointer algorithm.
// Time: O(n), Space: O(1)

public class LinkedListCycle {

    static class ListNode {
        int val; ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;  // cycle detected
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListCycle sol = new LinkedListCycle();

        // List with cycle: 3->2->0->-4 -> back to node 2
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // cycle
        System.out.println("Has cycle: " + sol.hasCycle(head)); // true

        // No cycle: 1->2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println("Has cycle: " + sol.hasCycle(head2)); // false

        // Single node
        ListNode head3 = new ListNode(1);
        System.out.println("Has cycle: " + sol.hasCycle(head3)); // false
    }
}
