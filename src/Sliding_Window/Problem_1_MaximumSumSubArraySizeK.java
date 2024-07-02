package Sliding_Window;

// Problem Statement: Maximum Sum Subarray of Size K (easy)
// LeetCode Question: 2461. Maximum Sum of Distinct Subarrays With Length K

public class Problem_1_MaximumSumSubArraySizeK {
    // Beats 100.00% of users with Java
    class Solution {
        public long maximumSubarraySum(int[] nums, int k) {
            int size = nums.length;
            int minNum = nums[0];
            int maxNum = nums[0];
            for (int idx = 1; idx < size; idx++) {
                if (nums[idx] < minNum) {
                    minNum = nums[idx];
                } else if (nums[idx] > maxNum) {
                    maxNum = nums[idx];
                }
            }

            if (k == 1) {
                return maxNum;
            }

            if (minNum == maxNum) {
                return 0L;
            }

            int range = maxNum - minNum + 1; // 9
            int[] windowSet = new int[range]; // [1,0,0,0,0,0,0,0,0]
            int windowSize = 0;
            int minIdx = 0;
            long windowSum = 0L;
            long maxWindowSum = 0L;
            for (int idx = 0; idx < size; idx++) {
                while (windowSet[nums[idx] - minNum] != 0) {
                    windowSet[nums[minIdx] - minNum] = 0;
                    windowSize--;
                    windowSum -= nums[minIdx];
                    minIdx++;
                }
                windowSet[nums[idx] - minNum] = idx + 1;
                windowSize++;
                windowSum += nums[idx];
                if (windowSize == k) {
                    if (maxWindowSum < windowSum) {
                        maxWindowSum = windowSum;
                    }
                    windowSet[nums[minIdx] - minNum] = 0;
                    windowSize--;
                    windowSum -= nums[minIdx];
                    minIdx++;
                }
            }
            return maxWindowSum;

        }
    }
    // Beats 18.65% of users with Java
    public int findMaxSumSubArray(int k, int[] arr) {
        // TODO: Write your code here
        int maxSum = 0, currentMax = 0;
        for(int i = 0; i < k; i++){
            currentMax += arr[i];
        }
        for(int j = k; j < arr.length; j++){
            currentMax += arr[j] - arr[j - k];
            maxSum = Math.max(maxSum, currentMax);
        }
        return maxSum;
    }
}
