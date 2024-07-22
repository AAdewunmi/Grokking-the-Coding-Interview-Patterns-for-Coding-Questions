package Dynamic_Programming.Fibonacci_Numbers;

// Problem Statement: Number factors
// LeetCode Question:

public class Problem_3_Number_Factors {

    // Brute Force Approach
    public int countWays(int n) {
        if( n == 0)
            return 1; // base case, we don't need to subtract any thing, so there is only one way

        if(n == 1)
            return 1; // we can subtract 1 to be left with zero, and that is the only way

        if(n == 2)
            return 1; // we can subtract 1 twice to get zero and that is the only way

        if(n == 3)
            return 2; // '3' can be expressed as {1,1,1}, {3}

        // if we subtract 1, we are left with 'n-1'
        int subtract1 = countWays(n-1);
        // if we subtract 3, we are left with 'n-3'
        int subtract3 = countWays(n-3);
        // if we subtract 4, we are left with 'n-4'
        int subtract4 = countWays(n-4);

        return subtract1 + subtract3 + subtract4;
    }

    // Top-down Dynamic Programming with Memoization Approach
    public int countWays_1(int n) {
        int dp[] = new int[n + 1];
        return countWaysRecursive(dp, n);
    }

    public int countWaysRecursive(int[] dp, int n) {
        if (n == 0)
            return 1; // base case, we don't need to subtract any thing, so there is only one way

        if (n == 1)
            return 1; // we can take subtract 1 to be left with zero, and that is the only way

        if (n == 2)
            return 1; // we can subtract 1 twice to get zero and that is the only way

        if (n == 3)
            return 2; // '3' can be expressed as {1,1,1}, {3}

        if (dp[n] == 0) {
            // if we subtract 1, we are left with 'n-1'
            int subtract1 = countWaysRecursive(dp, n - 1);
            // if we subtract 3, we are left with 'n-3'
            int subtract3 = countWaysRecursive(dp, n - 3);
            // if we subtract 4, we are left with 'n-4'
            int subtract4 = countWaysRecursive(dp, n - 4);
            dp[n] = subtract1 + subtract3 + subtract4;
        }

        return dp[n];
    }

    // Bottom-up Dynamic Programming Approach
    public int countWays_2(int n) {
        // bottom up
        int n0 = 1, n1 = 1, n2 = 1, n3 = 2;
        for(int i = 4; i <= n; i++){
            int temp = n0 + n1 + n3;
            n0 = n1;
            n1 = n2;
            n2 = n3;
            n3 = temp;
        }
        return n3;
    }
}
