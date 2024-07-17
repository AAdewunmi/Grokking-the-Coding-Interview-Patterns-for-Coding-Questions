package Dynamic_Programming._1_0_Knapsack;

// Problem Statement: Target Sum (hard)
// LeetCode Question: 494. Target Sum

public class Problem_6_Target_Sum {

    public int findTargetSubsets(int[] num, int s) {
        int totalSum = 0;
        for (int n : num)
            totalSum += n;
        if(totalSum < s || (s + totalSum) % 2 == 1)
            return 0;
        return countSubsets(num, (s + totalSum) / 2);
    }

    private int countSubsets (int[] num, int sum) {
        int n = num.length;
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        for(int s=1; s <= sum ; s++) {
            dp[s] = (num[0] == s ? 1 : 0);
        }
        for(int i=1; i < num.length; i++) {
            for(int s=sum; s >= 0; s--) {
                if(s >= num[i])
                    dp[s] += dp[s-num[i]];
            }
        }
        return dp[sum];
    }

}
