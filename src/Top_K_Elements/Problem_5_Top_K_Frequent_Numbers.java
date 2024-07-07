package Top_K_Elements;

// Problem Statement: Top 'K' Frequent Numbers (medium)
// LeetCode Question: 347. Top K Frequent Elements

import java.util.*;

public class Problem_5_Top_K_Frequent_Numbers {
    public List<Integer> findTopKFrequentNumbers(int[] nums, int k) {

        Map<Integer, Integer> numFrequencyMap = new HashMap<>();
        for (int n : nums)
            numFrequencyMap.put(n, numFrequencyMap.getOrDefault(n, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap =
                new PriorityQueue<Map.Entry<Integer, Integer>>(
                        (e1, e2) -> e1.getValue() - e2.getValue());

        for (Map.Entry<Integer, Integer> entry : numFrequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<Integer> topNumbers = new ArrayList<>(k);
        while (!minHeap.isEmpty()) {
            topNumbers.add(minHeap.poll().getKey());
        }
        return topNumbers;
    }
}
