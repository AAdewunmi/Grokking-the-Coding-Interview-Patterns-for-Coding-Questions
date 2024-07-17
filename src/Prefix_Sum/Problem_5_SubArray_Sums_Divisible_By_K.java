package Prefix_Sum;

// Problem Statement: Subarray Sums Divisible by K
// LeetCode Question: 974. Subarray Sums Divisible by K

import java.util.HashMap;

public class Problem_5_SubArray_Sums_Divisible_By_K {
    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> remainderCount = new HashMap<>();
        remainderCount.put(0, 1);
        int cumulativeSum = 0, count = 0;
        
        for (int num : nums) {
            cumulativeSum += num;
            int remainder = cumulativeSum % k;
            if (remainder < 0) remainder += k;
            count += remainderCount.getOrDefault(remainder, 0);
            remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
