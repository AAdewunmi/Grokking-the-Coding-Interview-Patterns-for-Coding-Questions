package Prefix_Sum;

// Problem Statement: Binary Subarrays With Sum (medium)
// LeetCode Question: 930. Binary Subarrays With Sum

import java.util.HashMap;

public class Problem_4_Binary_SubArrays_With_Sum {
    public int numSubarrayWithSum(int[] nums, int goal){
        int count = 0;
        int prefix_sum = 0;
        HashMap<Integer, Integer> prefix_sums = new HashMap<>();
        prefix_sums.put(0, 1);
        for (int num : nums) {
            prefix_sum += num;
            if (prefix_sums.containsKey(prefix_sum - goal)) {
                count += prefix_sums.get(prefix_sum - goal);
            }
            prefix_sums.put(prefix_sum, prefix_sums.getOrDefault(prefix_sum, 0) + 1);
        }
        return count;
    }
}
