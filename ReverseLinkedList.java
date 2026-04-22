// LeetCode #206 - Reverse Linked List
// Reverse a singly linked list iteratively and recursively.
// Time: O(n), Space: O(1) iterative

public class ReverseLinkedList {

    static class ListNode {
        int val; ListNode next;
        ListNode(int val) { this.val = val; }
    }

    // Iterative
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Recursive
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    static ListNode build(int... vals) {
        ListNode dummy = new ListNode(0), cur = dummy;
        for (int v : vals) { cur.next = new ListNode(v); cur = cur.next; }
        return dummy.next;
    }

    static String print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) { sb.append(head.val).append(head.next != null ? "->" : ""); head = head.next; }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseLinkedList sol = new ReverseLinkedList();
        System.out.println(print(sol.reverseList(build(1,2,3,4,5))));         // 5->4->3->2->1
        System.out.println(print(sol.reverseListRecursive(build(1,2,3,4,5)))); // 5->4->3->2->1
        System.out.println(print(sol.reverseList(build(1,2))));               // 2->1
    }
}
