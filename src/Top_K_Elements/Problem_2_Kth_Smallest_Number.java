package Top_K_Elements;

// Problem Statement: Kth Smallest Number (easy)
// LeetCode Question:

import java.util.PriorityQueue;

public class Problem_2_Kth_Smallest_Number {
    public int findKthSmallestNumber(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((n1, n2) -> n2 - n1);

        for (int i = 0; i < k; i++)
            maxHeap.add(nums[i]);

        for (int i = k; i < nums.length; i++) {
            if (nums[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }

        return maxHeap.peek();
    }
}
