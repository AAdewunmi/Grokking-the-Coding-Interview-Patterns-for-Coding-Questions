package Monotonic_Stack;

// Problem Statement: Remove Nodes From Linked List (easy)
// LeetCode Question: 2487. Remove Nodes From Linked List

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
public class Problem_3_Nodes_From_Linked_List {

    public ListNode removeNodes(ListNode head){
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            while (!stack.isEmpty() && stack.peek().val < cur.val){
                stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().next = cur;
            }
            stack.push(cur);
            cur = cur.next;
        }
        return stack.isEmpty() ? null : stack.get(0);
    }
}
