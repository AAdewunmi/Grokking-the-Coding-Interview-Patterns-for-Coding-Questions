package Dynamic_Programming.Unbounded_Knapsack;

// Problem Statement: Unbounded Knapsack
// LeetCode Question:

public class Problem_1_Unbounded_Knapsack {
    // Brute Force Solution
    class Solution_1 {
        public int solveKnapsack(int[] profits, int[] weights, int capacity) {
            return this.knapsackRecursive(profits, weights, capacity, 0);
        }

        private int knapsackRecursive(int[] profits, int[] weights, int capacity, int currentIndex) {
            // base checks
            if (capacity <= 0 || profits.length == 0 || weights.length != profits.length ||
                    currentIndex >= profits.length)
                return 0;

            // recursive call after choosing the items at the currentIndex, note that we recursive call on all
            // items as we did not increment currentIndex
            int profit1 = 0;
            if (weights[currentIndex] <= capacity)
                profit1 = profits[currentIndex]
                        + knapsackRecursive(profits, weights, capacity - weights[currentIndex], currentIndex);

            // recursive call after excluding the element at the currentIndex
            int profit2 = knapsackRecursive(profits, weights, capacity, currentIndex + 1);

            return Math.max(profit1, profit2);
        }
    }

    // Top-down Dynamic Programming with Memoization Solution
    class Solution_2 {

        public int solveKnapsack(int[] profits, int[] weights, int capacity) {
            Integer[][] dp = new Integer[profits.length][capacity + 1];
            return this.knapsackRecursive(dp, profits, weights, capacity, 0);
        }

        private int knapsackRecursive(Integer[][] dp, int[] profits, int[] weights, int capacity,
                                      int currentIndex) {

            // base checks
            if (capacity <= 0 || profits.length == 0 || weights.length != profits.length ||
                    currentIndex >= profits.length)
                return 0;

            // check if we have not already processed a similar sub-problem
            if(dp[currentIndex][capacity] == null) {
                // recursive call after choosing the items at the currentIndex, note that we recursive call on all
                // items as we did not increment currentIndex
                int profit1 = 0;
                if( weights[currentIndex] <= capacity )
                    profit1 = profits[currentIndex] + knapsackRecursive(dp, profits, weights,
                            capacity - weights[currentIndex], currentIndex);

                // recursive call after excluding the element at the currentIndex
                int profit2 = knapsackRecursive(dp, profits, weights, capacity, currentIndex + 1);

                dp[currentIndex][capacity] = Math.max(profit1, profit2);
            }

            return dp[currentIndex][capacity];
        }

    }

    // Bottom-up Dynamic Programming Solution
    class Solution_3 {

        public int solveKnapsack(int[] profits, int[] weights, int capacity) {
            // base checks
            if (capacity <= 0 || profits.length == 0 || weights.length != profits.length)
                return 0;

            int n = profits.length;
            int[][] dp = new int[n][capacity + 1];

            // populate the capacity=0 columns
            for(int i=0; i < n; i++)
                dp[i][0] = 0;

            // process all sub-arrays for all capacities
            for(int i=0; i < n; i++) {
                for(int c=1; c <= capacity; c++) {
                    int profit1=0, profit2=0;
                    if(weights[i] <= c)
                        profit1 = profits[i] + dp[i][c-weights[i]];
                    if( i > 0 )
                        profit2 = dp[i-1][c];
                    dp[i][c] = profit1 > profit2 ? profit1 : profit2;
                }
            }

            // maximum profit will be in the bottom-right corner.
            return dp[n-1][capacity];
        }

    }


}
