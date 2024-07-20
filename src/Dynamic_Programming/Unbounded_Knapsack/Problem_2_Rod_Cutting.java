package Dynamic_Programming.Unbounded_Knapsack;

// Problem Statement: Rod Cutting
// LeetCode Question:

public class Problem_2_Rod_Cutting {
    // Bottom-up Dynamic Programming
    class Solution_1 {

        public int solveRodCutting(int[] lengths, int[] prices, int n) {
            // base checks
            if (n <= 0 || prices.length == 0 || prices.length != lengths.length)
                return 0;

            int lengthCount = lengths.length;
            int[][] dp = new int[lengthCount][n + 1];

            // process all rod lengths for all prices
            for(int i=0; i < lengthCount; i++) {
                for(int len=1; len <= n; len++) {
                    int p1=0, p2=0;
                    if(lengths[i] <= len)
                        p1 = prices[i] + dp[i][len-lengths[i]];
                    if( i > 0 )
                        p2 = dp[i-1][len];
                    dp[i][len] = Math.max(p1, p2);
                }
            }

            // maximum price will be at the bottom-right corner.
            return dp[lengthCount-1][n];
        }
    }

}
