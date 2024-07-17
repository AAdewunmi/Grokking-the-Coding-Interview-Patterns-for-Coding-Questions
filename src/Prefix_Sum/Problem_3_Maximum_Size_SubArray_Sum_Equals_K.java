package Prefix_Sum;

// Problem Statement: Maximum Size Subarray Sum Equals k (medium)
// LeetCode Question: 325. Maximum Size Subarray Sum Equals k

import java.util.HashMap;
import java.util.Map;

public class Problem_3_Maximum_Size_SubArray_Sum_Equals_K {
    public int maxSubArrayLen(int[] nums, int k){
        Map<Integer, Integer> cumMap = new HashMap<>();
        int cumSum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            cumSum += nums[i];
            if (cumSum == k) {
                maxLen = i + 1;
            }
            if (cumMap.containsKey(cumSum - k)) {
                maxLen = Math.max(maxLen, i - cumMap.get(cumSum - k));
            }
            if (!cumMap.containsKey(cumSum)) {
                cumMap.put(cumSum, i);
            }
        }
        return maxLen;
    }
}
