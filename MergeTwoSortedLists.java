// LeetCode #21 - Merge Two Sorted Lists
// Merge two sorted linked lists and return as one sorted list.
// Time: O(m+n), Space: O(1)

public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur   = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) { cur.next = l1; l1 = l1.next; }
            else                  { cur.next = l2; l2 = l2.next; }
            cur = cur.next;
        }
        cur.next = (l1 != null) ? l1 : l2;
        return dummy.next;
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
        MergeTwoSortedLists sol = new MergeTwoSortedLists();
        System.out.println(print(sol.mergeTwoLists(build(1,2,4), build(1,3,4)))); // [1,1,2,3,4,4]
        System.out.println(print(sol.mergeTwoLists(build(), build())));             // []
        System.out.println(print(sol.mergeTwoLists(build(), build(0))));            // [0]
    }
}
