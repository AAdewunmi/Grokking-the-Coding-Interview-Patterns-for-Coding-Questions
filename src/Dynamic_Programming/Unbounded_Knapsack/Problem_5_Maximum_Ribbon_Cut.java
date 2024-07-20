package Dynamic_Programming.Unbounded_Knapsack;

// Problem Statement: Maximum Ribbon Cut
// LeetCode Question:

public class Problem_5_Maximum_Ribbon_Cut {
    //  Brute-Force solution
    class Solution_1 {

        public int countRibbonPieces(int[] ribbonLengths, int total) {
            int maxPieces = this.countRibbonPiecesRecursive(ribbonLengths, total, 0);
            return maxPieces == Integer.MIN_VALUE ? -1 : maxPieces;
        }

        private int countRibbonPiecesRecursive(int[] ribbonLengths, int total, int currentIndex) {
            // base check
            if (total == 0)
                return 0;

            if(ribbonLengths.length == 0 || currentIndex >= ribbonLengths.length)
                return Integer.MIN_VALUE;

            // recursive call after selecting the ribbon length at the currentIndex
            // if the ribbon length at the currentIndex exceeds the total, we shouldn't process this
            int c1 = Integer.MIN_VALUE;
            if( ribbonLengths[currentIndex] <= total ) {
                int result = countRibbonPiecesRecursive(
                        ribbonLengths, total - ribbonLengths[currentIndex], currentIndex);
                if(result != Integer.MIN_VALUE){
                    c1 = result + 1;
                }
            }

            // recursive call after excluding the ribbon length at the currentIndex
            int c2 = countRibbonPiecesRecursive(ribbonLengths, total, currentIndex + 1);
            return Math.max(c1, c2);
        }

    }

    // Bottom-up Dynamic Programming
    class Solution {

        public int countRibbonPieces(int[] ribbonLengths, int total)
        {
            int n = ribbonLengths.length;
            int[][] dp = new int[n][total + 1];

            for(int i=0; i < n; i++)
                for(int j=0; j <= total; j++)
                    dp[i][j] = Integer.MIN_VALUE;

            // populate the total=0 columns, as we don't need any ribbon to make zero total
            for(int i=0; i < n; i++)
                dp[i][0] = 0;

            for(int i=0; i < n; i++) {
                for(int t=1; t <= total; t++) {
                    if(i > 0) //exclude the ribbon
                        dp[i][t] = dp[i-1][t];
                    // include the ribbon and check if the remaining length can be cut into available lengths
                    if(t >= ribbonLengths[i] && dp[i][t-ribbonLengths[i]] != Integer.MIN_VALUE)
                        dp[i][t] = Math.max(dp[i][t], dp[i][t-ribbonLengths[i]]+1);
                }
            }

            // total combinations will be at the bottom-right corner, return '-1' if cutting is not possible
            return (dp[n-1][total] == Integer.MIN_VALUE ? -1 : dp[n-1][total]);
        }

    }

}
