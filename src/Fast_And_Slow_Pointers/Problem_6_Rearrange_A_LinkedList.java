package Fast_And_Slow_Pointers;

// Problem Statement: Rearrange a LinkedList (medium)
// LeetCode Question: 143. Reorder List

public class Problem_6_Rearrange_A_LinkedList {
    class ListNode{
        int val = 0;
        ListNode next;
        ListNode(int value){
            this.val = value;
        }
    }

    public ListNode reorder(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode headSecondHalf = reverse(slow);
        ListNode headFirstHalf = head;
        while(headFirstHalf != null && headSecondHalf != null){
            ListNode temp = headFirstHalf.next;
            headFirstHalf.next = headSecondHalf;
            headFirstHalf = temp;

            temp = headSecondHalf.next;
            headSecondHalf.next = headFirstHalf;
            headSecondHalf = temp;
        }
        if (headFirstHalf != null) {
            headFirstHalf.next = null;
        }
        return head;
    }

    private static ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
