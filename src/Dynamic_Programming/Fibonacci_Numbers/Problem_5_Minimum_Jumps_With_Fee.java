package Dynamic_Programming.Fibonacci_Numbers;

// Problem Statement: Minimum jumps with fee
// LeetCode Question:

public class Problem_5_Minimum_Jumps_With_Fee {
    // Brute Force Approach
    public int findMinFee(int[] fee) {
        return findMinFeeRecursive(fee, 0);
    }

    private int findMinFeeRecursive(int[] fee, int currentIndex) {
        if( currentIndex > fee.length - 1)
            return 0;

        // if we take 1 step, we are left with 'n-1' steps;
        int take1Step = findMinFeeRecursive(fee, currentIndex + 1);
        // similarly, if we took 2 steps, we are left with 'n-2' steps;
        int take2Step = findMinFeeRecursive(fee, currentIndex + 2);
        // if we took 3 steps, we are left with 'n-3' steps;
        int take3Step = findMinFeeRecursive(fee, currentIndex + 3);

        int min = Math.min(Math.min(take1Step, take2Step), take3Step);

        return min + fee[currentIndex];
    }

    // Top-down Dynamic Programming with Memoization Approach
    public int findMinFee_1(int[] fee) {
        int dp[] = new int[fee.length];
        return findMinFeeRecursive(dp, fee, 0);
    }

    private int findMinFeeRecursive(int[] dp, int[] fee, int currentIndex) {
        if( currentIndex > fee.length - 1)
            return 0;

        if(dp[currentIndex] == 0) {
            // if we take 1 step, we are left with 'n-1' steps;
            int take1Step = findMinFeeRecursive(dp, fee, currentIndex + 1);
            // similarly, if we took 2 steps, we are left with 'n-2' steps;
            int take2Step = findMinFeeRecursive(dp, fee, currentIndex + 2);
            // if we took 3 steps, we are left with 'n-3' steps;
            int take3Step = findMinFeeRecursive(dp, fee, currentIndex + 3);

            dp[currentIndex] = fee[currentIndex] + Math.min(Math.min(take1Step, take2Step), take3Step);
        }

        return dp[currentIndex];
    }

    // Bottom-up Dynamic Programming Approach
    public int findMinFee_2(int[] fee) {
        int dp[] = new int[fee.length + 1]; // +1 to handle the 0th step
        dp[0] = 0; // if there are no steps, we dont have to pay any fee
        dp[1] = fee[0]; // only one step, so we have to pay its fee
        // for 2 or 3 steps staircase, since we start from the first step so we have to pay its fee
        // and from the first step we can reach the top by taking two or three steps, so we don't
        // have to pay any other fee.
        dp[2] = dp[3] = fee[0];

        for (int i = 3; i < fee.length; i++)
            dp[i + 1] = Math.min(fee[i] + dp[i], Math.min(fee[i - 1] + dp[i - 1], fee[i - 2] + dp[i - 2]));

        return dp[fee.length];
    }
}
