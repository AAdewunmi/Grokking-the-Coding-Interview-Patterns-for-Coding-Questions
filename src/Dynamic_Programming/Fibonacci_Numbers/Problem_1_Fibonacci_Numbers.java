package Dynamic_Programming.Fibonacci_Numbers;

// Problem Statement: Fibonacci numbers
// LeetCode Question: 509. Fibonacci Number

public class Problem_1_Fibonacci_Numbers {
    // Brute Force Approach
    public int calculateFibonacci_1(int n) {
        if(n < 2)
            return n;
        return calculateFibonacci(n-1) + calculateFibonacci(n-2);
    }

    // Top-down Dynamic Programming with Memoization Approach
    public int calculateFibonacci_2(int n) {
        int dp[] = new int[n + 1];
        return calculateFibonacciRecursive(dp, n);
    }

    public int calculateFibonacciRecursive(int[] dp, int n) {
        if (n < 2)
            return n;
        if (dp[n] == 0)
            dp[n] = calculateFibonacciRecursive(dp, n - 1) + calculateFibonacciRecursive(dp, n - 2);
        return dp[n];
    }

    // Bottom-up Dynamic Programming Approach
    public int calculateFibonacci_3(int n) {
        if (n < 2)
            return n;

        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    // Memory optimization Approach
    public int calculateFibonacci(int n) {
        if (n < 2)
            return n;
        int n1 = 0, n2 = 1, temp;
        for (int i = 2; i <= n; i++) {
            temp = n1 + n2;
            n1 = n2;
            n2 = temp;
        }
        return n2;
    }
}
