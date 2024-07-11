package Backtracking;

// Problem Statement: Factor Combinations (medium)
// LeetCode Question: 254. Factor Combinations

import java.util.ArrayList;
import java.util.List;

public class Problem_4_Factor_Combinations {

    public List<List<Integer>> getAllFactors(int n, int start, List<Integer> curr, List<List<Integer>> result) {
        for (int i = start; i <= (int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                curr.add(i);
                List<Integer> currCopy = new ArrayList<>(curr);
                currCopy.add(n/i);
                result.add(currCopy);
                getAllFactors(n / i, i, curr, result);
                curr.remove(curr.size() - 1);
            }
        }
        return result;
    }

    public List<List<Integer>> getFactors(int n) {
        return getAllFactors(n, 2, new ArrayList<Integer>(), new ArrayList<List<Integer>>());
    }

}
