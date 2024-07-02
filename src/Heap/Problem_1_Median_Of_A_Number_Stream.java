package Heap;

// Problem Statement: Find the Median of a Number Stream (medium)
// LeetCode Question: 295. Find Median from Data Stream

import java.util.PriorityQueue;

public class Problem_1_Median_Of_A_Number_Stream {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public Problem_1_Median_Of_A_Number_Stream() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(int num){
        if (maxHeap.isEmpty() || maxHeap.peek() >= num) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian(){
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        }
        return maxHeap.peek();
    }

}
