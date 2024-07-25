package Dynamic_Programming.Longest_Common_SubString;

// Problem Statement: Minimum Deletions to Make a Sequence Sorted
// LeetCode Question:

public class Problem_7_Minimum_Deletions_To_Make_A_Sequence_Sorted {
    // Bottom-up Dynamic Programming
    public int findMinimumDeletions(int[] nums){
        // subtracting the length of LIS from the length of the input array to get minimum number of deletions
        return nums.length - findLISLength(nums);
    }

    private int findLISLength(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        int maxLength = 1;
        for (int i=1; i<nums.length; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++)
                if (nums[i] > nums[j] && dp[i] <= dp[j] ) {
                    dp[i] = dp[j]+1;
                    maxLength = Math.max(maxLength, dp[i]);
                }
        }
        return maxLength;
    }
}
