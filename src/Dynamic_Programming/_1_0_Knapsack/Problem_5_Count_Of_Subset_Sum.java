package Dynamic_Programming._1_0_Knapsack;

// Problem Statement: Count of Subset Sum (hard)
// LeetCode Question:

public class Problem_5_Count_Of_Subset_Sum {
    public int countSubsets(int[] num, int sum) {
        int n = num.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;

        // with only one number, we can form a subset only when the required sum is equal
        // to its value
        for(int s=1; s <= sum ; s++) {
            dp[s] = (num[0] == s ? 1 : 0);
        }

        // process all subsets for all sums
        for(int i=1; i < num.length; i++) {
            for(int s=sum; s >= 0; s--) {
                if(s >= num[i])
                    dp[s] += dp[s-num[i]];
            }
        }

        return dp[sum];
    }
}
