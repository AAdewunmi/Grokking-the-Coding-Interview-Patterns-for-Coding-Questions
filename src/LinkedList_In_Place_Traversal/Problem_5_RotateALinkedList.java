package LinkedList_In_Place_Traversal;

// Problem Statement: Rotate a LinkedList (medium)
// LeetCode Question: 61. Rotate List

public class Problem_5_RotateALinkedList {
    class ListNode {
        int val = 0;
        ListNode next;

        ListNode(int value) {
            this.val = value;
        }
    }

    public ListNode rotate(ListNode head, int rotations) {
        if (head == null || head.next == null || rotations <= 0) {
            return head;
        }
        ListNode lastNode = head;
        int listLength = 1;
        while (lastNode.next != null){
            lastNode = lastNode.next;
            listLength++;
        }
        lastNode.next = head;
        rotations %= listLength;
        int skipLength = listLength - rotations;
        ListNode lastNodeOfRotatedList = head;
        for (int i = 0; i < skipLength - 1; i++) {
            lastNodeOfRotatedList = lastNodeOfRotatedList.next;
        }
        head = lastNodeOfRotatedList.next;
        lastNodeOfRotatedList.next = null;
        return head;
    }
}
