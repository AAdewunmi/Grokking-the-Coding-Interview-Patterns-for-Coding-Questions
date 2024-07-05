package LinkedList_In_Place_Traversal;

// Problem Statement: Reverse alternating K-element Sub-list (medium)
// LeetCode Question: -

public class Problem_4_ReverseAlternatingKElementSubList {
    class ListNode {
        int val = 0;
        ListNode next;
        ListNode (int value) {
            this.val = value;
        }
    }

    public ListNode reverse (ListNode head, int k){
        if (k <= 1 || head == null) {
            return head;
        }
        ListNode current = head, previous = null;
        while (current != null){
            ListNode lastNodeOfPreviousPart = previous;
            ListNode lastNodeOfSubList = current;
            ListNode next = null;
            for (int i = 0; current != null && i < k; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            if (lastNodeOfPreviousPart != null) {
                lastNodeOfPreviousPart.next = previous;
            } else {
                head = previous;
            }
            lastNodeOfSubList.next = current;
            for (int i = 0; current != null && i < k; ++i) {
                previous = current;
                current = current.next;
            }
        }
        return head;
    }
}
