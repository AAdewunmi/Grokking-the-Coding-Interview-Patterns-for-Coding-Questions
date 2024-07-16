package Ordered_Set;

// Problem Statement: Merge Similar Items (easy)
// LeetCode Question: 2363. Merge Similar Items

import java.util.*;

public class Problem_1_Merge_Similar_Items {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        // TreeMap to maintain order of keys (item IDs) and to store sums of values
        Map<Integer, Integer> mergedItems = new TreeMap<>();

        // Process items from the first array
        for (int[] item : items1) {
            mergedItems.put(item[0], mergedItems.getOrDefault(item[0], 0) + item[1]);
        }

        // Process items from the second array
        for (int[] item : items2) {
            mergedItems.put(item[0], mergedItems.getOrDefault(item[0], 0) + item[1]);
        }

        // Convert map entries to a list of lists
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mergedItems.entrySet()) {
            result.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }

        return result;
    }
}
