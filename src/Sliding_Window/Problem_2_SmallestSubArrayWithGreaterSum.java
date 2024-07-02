package Sliding_Window;

// Problem Statement: Smallest Subarray With a Greater Sum (easy)
// LeetCode Question: 209. Minimum Size Subarray Sum


public class Problem_2_SmallestSubArrayWithGreaterSum {
    public int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            while(windowSum >= S){
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
