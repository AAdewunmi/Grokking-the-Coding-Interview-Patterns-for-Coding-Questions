package Top_K_Elements;

// Problem Statement: Kth Largest Number in a Stream
// LeetCode Question: 703. Kth Largest Element in a Stream

import java.util.PriorityQueue;

public class Problem_7_Kth_Largest_Number_In_A_Stream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
    final int k;

    public Problem_7_Kth_Largest_Number_In_A_Stream(int[] nums, int k) {
        this.k = k;
        for (int i = 0; i < nums.length; i++)
            add(nums[i]);
    }

    public int add(int num) {
        minHeap.add(num);

        if (minHeap.size() > this.k)
            minHeap.poll();
        
        return minHeap.peek();
    }
}
