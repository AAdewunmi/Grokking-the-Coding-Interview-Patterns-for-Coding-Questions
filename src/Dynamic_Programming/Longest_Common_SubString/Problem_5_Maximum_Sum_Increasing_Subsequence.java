package Dynamic_Programming.Longest_Common_SubString;

// Problem Statement: Maximum Sum Increasing Subsequence
// LeetCode Question:

import java.util.HashMap;
import java.util.Map;

public class Problem_5_Maximum_Sum_Increasing_Subsequence {
    // Brute Force Approach
    public int findMSIS(int[] nums) {
        return findMSISRecursive(nums, 0, -1, 0);
    }

    private int findMSISRecursive(int[] nums, int currentIndex, int previousIndex, int sum) {
        if(currentIndex == nums.length)
            return sum;

        // include nums[currentIndex] if it is larger than the last included number
        int s1 = sum;
        if(previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
            s1 = findMSISRecursive(nums, currentIndex+1, currentIndex, sum + nums[currentIndex]);

        // excluding the number at currentIndex
        int s2 = findMSISRecursive(nums, currentIndex+1, previousIndex, sum);

        return Math.max(s1, s2);
    }

    // Top-down Dynamic Programming with Memoization Approach
    public int findMSIS_1(int[] nums) {
        Map<String, Integer> dp = new HashMap<>();
        return findMSISRecursive(dp, nums, 0, -1, 0);
    }

    private int findMSISRecursive(Map<String, Integer> dp, int[] nums, int currentIndex, int previousIndex, int sum) {
        if(currentIndex == nums.length)
            return sum;

        String subProblemKey = currentIndex + "-" + previousIndex + "-" + sum;
        if(!dp.containsKey(subProblemKey)) {
            // include nums[currentIndex] if it is larger than the last included number
            int s1 = sum;
            if(previousIndex == -1 || nums[currentIndex] > nums[previousIndex])
                s1 = findMSISRecursive(dp, nums, currentIndex+1, currentIndex, sum + nums[currentIndex]);

            // excluding the number at currentIndex
            int s2 = findMSISRecursive(dp, nums, currentIndex+1, previousIndex, sum);
            dp.put(subProblemKey, Math.max(s1, s2));
        }

        return dp.get(subProblemKey);
    }

    // Bottom-up Dynamic Programming
    public int findMSIS_2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int maxSum = nums[0];
        for (int i=1; i<nums.length; i++) {
            dp[i] = nums[i];
            for (int j=0; j<i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + nums[i])
                    dp[i] = dp[j] + nums[i];
            }
            maxSum = Math.max(maxSum, dp[i]);
        }

        return maxSum;
    }
}
