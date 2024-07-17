package Prefix_Sum;

// Problem Statement: Sum of Absolute Differences in a Sorted Array (medium)
// LeetCode Question: 1685. Sum of Absolute Differences in a Sorted Array

public class Problem_6_Sum_Of_Absolute_Differences_In_A_Sorted_Array {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] prefixSum = new int[n + 1];

        // Calculate prefix sums
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // Calculate result array
        for (int i = 0; i < n; i++) {
            int leftSum = prefixSum[i];
            int rightSum = prefixSum[n] - prefixSum[i + 1];
            result[i] = i * nums[i] - leftSum + rightSum - (n - i - 1) * nums[i];
        }

        return result;
    }
}
