package Dynamic_Programming.Fibonacci_Numbers;

// Problem Statement: House thief
// LeetCode Question: 198. House Robber

public class Problem_6_House_Thief {
    // Brute Force Approach
    public int findMaxSteal(int[] wealth) {
        return findMaxStealRecursive(wealth, 0);
    }

    private int findMaxStealRecursive(int[] wealth, int currentIndex) {
        if( currentIndex >= wealth.length)
            return 0;

        // steal from current house and skip one to steal from the next house
        int stealCurrent = wealth[currentIndex] + findMaxStealRecursive(wealth, currentIndex + 2);
        // skip current house to steel from the adjacent house
        int skipCurrent = findMaxStealRecursive(wealth, currentIndex + 1);

        return Math.max(stealCurrent, skipCurrent);
    }

    // Top-down Dynamic Programming with Memoization Approach
    public int findMaxSteal_1(int[] wealth) {
        int dp[] = new int[wealth.length];
        return findMaxStealRecursive(dp, wealth, 0);
    }

    private int findMaxStealRecursive(int[] dp, int[] wealth, int currentIndex) {
        if( currentIndex >= wealth.length)
            return 0;

        if(dp[currentIndex] == 0) {
            // steal from current house and skip one to steal next
            int stealCurrent = wealth[currentIndex] + findMaxStealRecursive(dp, wealth, currentIndex + 2);
            // skip current house to steel from the adjacent house
            int skipCurrent = findMaxStealRecursive(dp, wealth, currentIndex + 1);

            dp[currentIndex] = Math.max(stealCurrent, skipCurrent);
        }
        return dp[currentIndex];
    }

    // Bottom-up Dynamic Programming Approach
    public int findMaxSteal_2(int[] wealth) {
        if(wealth.length == 0) return 0;
        int dp[] = new int[wealth.length+1]; // '+1' to handle the zero house
        dp[0] = 0; // if there are no houses, the thief can't steal anything
        dp[1] = wealth[0]; // only one house, so the thief have to steal from it

        // please note that dp[] has one extra element to handle zero house
        for(int i=1; i < wealth.length; i++)
            dp[i+1] = Math.max(wealth[i] + dp[i-1], dp[i]);

        return dp[wealth.length];
    }

    // Memory optimization Approach
    public int findMaxSteal_3(int[] wealth) {
        if(wealth.length == 0) return 0;
        int n1=0, n2=wealth[0], temp;
        for(int i=1; i < wealth.length; i++) {
            temp = Math.max(n1 + wealth[i], n2);
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }
}
