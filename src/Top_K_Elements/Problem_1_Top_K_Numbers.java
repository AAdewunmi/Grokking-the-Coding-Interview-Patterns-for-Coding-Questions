package Top_K_Elements;

// Problem Statement: Top 'K' Numbers (easy)
// LeetCode Question:

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Problem_1_Top_K_Numbers {
    public List<Integer> findKLargestNumbers(int[] nums, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return new ArrayList<>(minHeap);
    }
}
