package LinkedList_In_Place_Traversal;

// Problem Statement: Reverse a LinkedList (easy)
// LeetCode Question: 206. Reverse Linked List

public class Problem_1_ReverseALinkedList {
    class ListNode {
        int val = 0;
        ListNode next;
        ListNode(int value){
            this.val = value;
        }
    }

    public ListNode reverse (ListNode head) {
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
