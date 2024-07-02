package Sliding_Window;

// Problem Statement: Longest Subarray with Ones after Replacement (hard)
// LeetCode Question: 1004. Max Consecutive Ones III

public class Problem_6_LongestSubArrayWithOnesAfterReplacement {
    public int findLength(int[] arr, int k){
        int windowStart = 0, maxLength = 0, maxOnesCount = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            if (arr[windowEnd] == 1) {
                maxOnesCount++;
            }
            if (windowEnd - windowStart + 1 - maxOnesCount > k) {
                if (arr[windowStart] == 1) {
                    maxOnesCount--;
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
