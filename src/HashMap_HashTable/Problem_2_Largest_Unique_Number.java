package HashMap_HashTable;

// Problem Statement: Largest Unique Number (easy)
// LeetCode Question: 1133. Largest Unique Number

import java.util.HashMap;

public class Problem_2_Largest_Unique_Number {
    public int largestUniqueNumber(int[] A) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num: A) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int maxUnique = -1;
        for (int key : freq.keySet()) {
            if (freq.get(key) == 1) {
                maxUnique = Math.max(maxUnique, key);
            }
        }
        return maxUnique;
    }
}
