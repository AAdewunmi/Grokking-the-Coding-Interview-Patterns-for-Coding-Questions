package Dynamic_Programming.Fibonacci_Numbers;

// Problem Statement: Fibonacci numbers
// LeetCode Question: 509. Fibonacci Number

public class Fibonacci_Numbers {
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
