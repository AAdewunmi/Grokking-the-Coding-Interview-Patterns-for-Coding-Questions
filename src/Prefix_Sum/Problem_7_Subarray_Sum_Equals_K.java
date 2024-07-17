package Prefix_Sum;

// Problem Statement: Subarray Sum Equals K (medium)
// LeetCode Question: 560. Subarray Sum Equals K

import java.util.HashMap;
import java.util.Map;

public class Problem_7_Subarray_Sum_Equals_K {
    public int subarraySum(int[] nums, int k) {
        int count = 0, cumulativeSum = 0;
        Map<Integer, Integer> cumulativeSumFrequency = new HashMap<>();
        cumulativeSumFrequency.put(0, 1);  // Initialize with 0 sum count as 1

        for (int num : nums) {
            cumulativeSum += num;  // Update cumulative sum
            // Check if there's a subarray sum that equals k
            count += cumulativeSumFrequency.getOrDefault(cumulativeSum - k, 0);
            // Update the frequency map for the current cumulative sum
            cumulativeSumFrequency.put(cumulativeSum, cumulativeSumFrequency.getOrDefault(cumulativeSum, 0) + 1);
        }

        return count;  // Return the total count of subarrays
    }
}
