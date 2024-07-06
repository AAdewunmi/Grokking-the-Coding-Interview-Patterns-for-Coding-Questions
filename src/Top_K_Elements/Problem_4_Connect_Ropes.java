package Top_K_Elements;

// Problem Statement: Connect Ropes
// LeetCode Question:

import java.util.PriorityQueue;

public class Problem_4_Connect_Ropes {
    public int minimumCostToConnectRopes(int[] ropeLengths) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        for (int i = 0; i < ropeLengths.length; i++)
            minHeap.add(ropeLengths[i]);

        int result = 0, temp = 0;
        while (minHeap.size() > 1) {
            temp = minHeap.poll() + minHeap.poll();
            result += temp;
            minHeap.add(temp);
        }

        return result;
    }
}
