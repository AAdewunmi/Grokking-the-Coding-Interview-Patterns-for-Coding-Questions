package Dynamic_Programming.Fibonacci_Numbers;

// Problem Statement: Minimum jumps to reach the end
// LeetCode Question:

public class Problem_4_Minimum_Jumps_To_Reach_The_End {
    // Brute Force Approach
    public int countMinJumps(int[] jumps) {
        return this.countMinJumpsRecursive(jumps, 0);
    }

    private int countMinJumpsRecursive(int[] jumps, int currentIndex) {
        // if we have reached the last index, we don't need any more jumps
        if( currentIndex == jumps.length - 1)
            return 0;

        if (jumps[currentIndex] == 0)
            return Integer.MAX_VALUE;

        int totalJumps = Integer.MAX_VALUE;
        int start = currentIndex + 1;
        int end = currentIndex + jumps[currentIndex];
        while(start < jumps.length && start <= end) {
            // jump one step and recurse for the remaining array
            int minJumps = countMinJumpsRecursive(jumps, start++);
            if(minJumps != Integer.MAX_VALUE)
                totalJumps = Math.min(totalJumps, minJumps + 1);
        }
        return totalJumps;
    }

    // Top-down Dynamic Programming with Memoization Approach
    public int countMinJumps_1(int[] jumps) {
        int dp[] = new int[jumps.length];
        return this.countMinJumpsRecursive(dp, jumps, 0);
    }

    private int countMinJumpsRecursive(int[] dp, int[] jumps, int currentIndex) {
        // if we have reached the last index, we don't need any more jumps
        if( currentIndex == jumps.length - 1)
            return 0;

        // If an element is 0, then we cannot move through that element
        if (jumps[currentIndex] == 0)
            return Integer.MAX_VALUE;

        // if we have already solved this problem, return the result
        if(dp[currentIndex] != 0)
            return dp[currentIndex];

        int totalJumps = Integer.MAX_VALUE;
        int start = currentIndex + 1;
        int end = currentIndex + jumps[currentIndex];
        while(start < jumps.length && start <= end) {
            // jump one step and recurse for the remaining array
            int minJumps = countMinJumpsRecursive(dp, jumps, start++);
            if(minJumps != Integer.MAX_VALUE)
                totalJumps = Math.min(totalJumps, minJumps + 1);
        }
        dp[currentIndex] = totalJumps;
        return dp[currentIndex];
    }

    // Bottom-up Dynamic Programming Approach
    public int countMinJumps_2(int[] jumps) {
        int[] dp = new int[jumps.length];

        //initialize with infinity, except the first index which should be zero as we start from there
        for(int i=1; i<jumps.length; i++)
            dp[i] = Integer.MAX_VALUE;

        for(int start=0; start < jumps.length-1; start++) {
            for(int end=start+1; end <= start+jumps[start] && end < jumps.length; end++)
                dp[end] = Math.min(dp[end], dp[start]+1);
        }

        return dp[jumps.length-1];
    }

    
}
