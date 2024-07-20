package Dynamic_Programming.Unbounded_Knapsack;

// Problem Statement: Coin Change
// LeetCode Question: 518. Coin Change II

public class Problem_3_Coin_Change {
    // Brute Force
    class Solution_1 {

        public int countChange(int[] denominations, int total) {
            return this.countChangeRecursive(denominations, total, 0);
        }

        private int countChangeRecursive(int[] denominations, int total, int currentIndex) {
            // basic checks
            if (total == 0)
                return 1;

            if(denominations.length == 0 || currentIndex >= denominations.length)
                return 0;

            // recursive call after selecting the coin at the currentIndex
            // if the coin at currentIndex exceeds the total, we shouldn't process this
            int sum1 = 0;
            if( denominations[currentIndex] <= total )
                sum1 = countChangeRecursive(denominations, total - denominations[currentIndex], currentIndex);

            // recursive call after excluding the coin at the currentIndex
            int sum2 = countChangeRecursive(denominations, total, currentIndex + 1);

            return sum1 + sum2;
        }

    }

    // Top-down Dynamic Programming with Memoization
    class Solution_2 {

        public int countChange(int[] denominations, int total)

        {
            Integer[][] dp = new Integer[denominations.length][total + 1];
            return this.countChangeRecursive(dp, denominations, total, 0);
        }

        private int countChangeRecursive(Integer[][] dp, int[] denominations, int
                total, int currentIndex)

        {
            // base checks
            if (total == 0)
                return 1;

            if(denominations.length == 0 || currentIndex >= denominations.length)
                return 0;

            // if we have already processed a similar sub-problem, return the result from memory
            if(dp[currentIndex][total] != null)
                return dp[currentIndex][total];

            // recursive call after selecting the coin at the currentIndex
            // if the number at currentIndex exceeds the total, we shouldn't process this
            int sum1 = 0;
            if( denominations[currentIndex] <= total )
                sum1 = countChangeRecursive(dp, denominations, total - denominations[currentIndex], currentIndex);

            // recursive call after excluding the number at the currentIndex
            int sum2 = countChangeRecursive(dp, denominations, total, currentIndex + 1);

            dp[currentIndex][total] = sum1 + sum2;
            return dp[currentIndex][total];
        }

    }
    // Bottom-up Dynamic Programming
    class Solution_3 {

        public int countChange(int[] denominations, int total) {
            int n = denominations.length;
            int[][] dp = new int[n][total + 1];

            // populate the total=0 columns, as we will always have an empty set for zero total
            for(int i=0; i < n; i++)
                dp[i][0] = 1;

            // process all sub-arrays for all capacities
            for(int i=0; i < n; i++) {
                for(int t=1; t <= total; t++) {
                    if(i > 0)
                        dp[i][t] = dp[i-1][t];
                    if(t >= denominations[i])
                        dp[i][t] += dp[i][t-denominations[i]];
                }
            }

            // total combinations will be at the bottom-right corner.
            return dp[n-1][total];
        }

    }

}
