package LinkedList_In_Place_Traversal;

// Problem Statement: Reverse every K-element Sub-list (medium)
// LeetCode Question: 25. Reverse Nodes in k-Group

public class Problem_3_ReverseEveryKElementSubList {
    class ListNode{
        int val = 0;
        ListNode next;
        public ListNode (int val){
            this.val = val;
        }
    }

    public static ListNode reverse(ListNode head, int k){
        if(k <= 1 || head == null){
            return head;
        }
        ListNode current = head, previous = null;
        while (true) {
            ListNode lastNodeOfPreviousPart = previous;
            ListNode lastNodeOfSublist = current;
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
            lastNodeOfSublist.next = current;
            if (current == null) {
                break;
            }
            previous = lastNodeOfSublist;
        }
        return head;
    }
}
