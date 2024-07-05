package LinkedList_In_Place_Traversal;

// Problem Statement: Reverse a Sub-list
// LeetCode Question: 92. Reverse Linked List II

public class Problem_2_ReverseASubList {
    class ListNode{
        int val = 0;
        ListNode next;
        ListNode(int value){
            this.val = value;
        }
    }

    public ListNode reverse(ListNode head, int p, int q){
        if (p == q) {
           return head;
        }
        ListNode current = head, previous = null;
        for (int i = 0; current != null && i < p - 1; i++) {
            previous = current;
            current = current.next;
        }
        ListNode lastNodeOfFirstPart = previous;
        ListNode lastNodeOfSubList = current;
        ListNode next = null;
        for (int i = 0; current != null && i < q - p + 1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous;
        } else {
            head = previous;
        }
        lastNodeOfSubList.next = current;
        return head;
    }
}
