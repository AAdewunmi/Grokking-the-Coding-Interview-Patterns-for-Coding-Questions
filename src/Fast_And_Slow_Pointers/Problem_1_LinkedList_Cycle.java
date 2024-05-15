package Fast_And_Slow_Pointers;

// Problem Statement: LinkedList Cycle (easy)
// LeetCode Question: 141. Linked List Cycle

public class Problem_1_LinkedList_Cycle {
    class ListNode  {
        int val = 0;
        ListNode next;
        public ListNode(int value){
            this.val = value;
        }
    }

    public boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}


