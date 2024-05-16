package Fast_And_Slow_Pointers;

// Problem Statement: Palindrome LinkedList (medium)
// LeetCode Question: 234. Palindrome Linked List

public class Problem_5_Palindrome_LinkedList {
    class ListNode {
        int val = 0;
        ListNode next;

        ListNode(int value){
            this.val = value;
        }
    }

    public boolean isPalindrome(ListNode head){
        if (head == null || head.next == null)
            return true;

        // find middle of the LinkedList
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode headSecondHalf = reverse(slow); // reverse the second half
        // store the head of reversed part to revert back later
        ListNode copyHeadSecondHalf = headSecondHalf;

        // compare the first and the second half
        while (head != null && headSecondHalf != null) {
            if (head.val != headSecondHalf.val) {
                break; // not a palindrome
            }
            head = head.next;
            headSecondHalf = headSecondHalf.next;
        }

        reverse(copyHeadSecondHalf); // revert the reverse of the second half
        if (head == null || headSecondHalf == null) // if both halves match
            return true;
        return false;
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
