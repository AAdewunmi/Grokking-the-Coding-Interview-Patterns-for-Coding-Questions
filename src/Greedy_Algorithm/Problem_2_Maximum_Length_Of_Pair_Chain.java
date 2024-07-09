package Greedy_Algorithm;

// Problem Statement: Maximum Length of Pair Chain (medium)
// LeetCode Question: 646. Maximum Length of Pair Chain

import java.util.Arrays;

public class Problem_2_Maximum_Length_Of_Pair_Chain {
    public int findLongestChain(int[][] pairs){
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int currentEnd = Integer.MIN_VALUE;
        int chainCount = 0;
        for (int[] pair : pairs) {
            if (pair[0] > currentEnd) {
                currentEnd = pair[1];
                chainCount++;
            }
        }
        return chainCount;
    }
}
