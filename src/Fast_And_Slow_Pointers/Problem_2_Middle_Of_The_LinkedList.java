package Fast_And_Slow_Pointers;

// Problem Statement: Middle of the LinkedList
// LeetCode Question: 876. Middle of the Linked List

public class Problem_2_Middle_Of_The_LinkedList {
    class ListNode{
        int val = 0;
        ListNode next;

        public ListNode (int value){
            this.val = value;
        }
    }

    public ListNode findMiddle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
