package Heap;

// Problem Statement: Sliding Window Median (hard)
// LeetCode Question: 480. Sliding Window Median

import java.util.Collections;
import java.util.PriorityQueue;

public class Problem_2_Sliding_Window_Median {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public double[] findSlidingWindowMedian(int[] nums, int k){
        double[] result = new double[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                maxHeap.add(nums[i]);
            } else {
                minHeap.add(nums[i]);
            } //
            rebalanceHeaps();
            if (i - k + 1 >= 0) {
                if (maxHeap.size() == minHeap.size()) {
                    result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else {
                    result[i - k + 1] = maxHeap.peek();
                }//
                int elementToBeRemoved = nums[i - k + 1];
                if (elementToBeRemoved <= maxHeap.peek()) {
                    maxHeap.remove(elementToBeRemoved);
                } else {
                    minHeap.remove(elementToBeRemoved);
                }//
                rebalanceHeaps();
            }//
        }//
        return result;
    }//

    private void rebalanceHeaps(){
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }
}
