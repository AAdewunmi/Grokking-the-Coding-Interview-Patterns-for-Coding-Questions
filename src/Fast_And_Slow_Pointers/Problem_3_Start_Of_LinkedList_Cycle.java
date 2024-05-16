package Fast_And_Slow_Pointers;

// Problem Statement: Start of LinkedList Cycle
// LeetCode Question: 142. Linked List Cycle II

public class Problem_3_Start_Of_LinkedList_Cycle {
    class ListNode{
        int val = 0;
        ListNode next;

        public ListNode(int value){
            this.val = value;
        }
    }

    public ListNode findCycleStart(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == head) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while(slow != fast){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
