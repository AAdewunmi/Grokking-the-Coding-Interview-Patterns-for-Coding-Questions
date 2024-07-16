package Ordered_Set;

// Problem Statement: Longest Continuous Subarray (medium)
// LeetCode Question: 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

import java.util.TreeMap;

public class Problem_4_Longest_Continuous_SubArray {
    // Function to find the longest subarray with absolute diff less than or equal to limit
    public static int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Contract the window if the condition is violated
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            // Update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
