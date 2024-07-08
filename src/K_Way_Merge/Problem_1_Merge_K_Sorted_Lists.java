package K_Way_Merge;

// Problem Statement: Merge K Sorted Lists (medium)
// LeetCode Question: 23. Merge k Sorted Lists

import java.util.PriorityQueue;

public class Problem_1_Merge_K_Sorted_Lists {

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode merge (ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2) -> n1.val - n2.val);
        for(ListNode root : lists){
            if (root != null) minHeap.add(root);
        }
        ListNode resultHead = null, resultTail = null;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            if (resultHead == null) {
                resultHead = resultTail = node;
            } else {
                resultTail.next = node;
                resultTail = resultTail.next;
            }
            if (node.next != null) minHeap.add(node.next);
        }
        return resultHead;
    }

}
