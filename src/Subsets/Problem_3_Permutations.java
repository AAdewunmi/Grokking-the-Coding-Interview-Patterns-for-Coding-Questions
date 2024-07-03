package Subsets;

// Problem Statement: Permutations (medium)
// LeetCode Question: 46. Permutations

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_3_Permutations {
    public List<List<Integer>> findPermutations (int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.add(new ArrayList<>());
        for (int currentNumber : nums) {
            int n = permutations.size();
            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = permutations.poll();
                for (int j = 0; j <= oldPermutation.size(); j++) {
                    List<Integer> newPermutation = new ArrayList<Integer>(oldPermutation);
                    newPermutation.add(j, currentNumber);
                    if (newPermutation.size() == nums.length) {
                        result.add(newPermutation);
                    } else {
                        permutations.add(newPermutation);
                    }
                }
            }
        }
        return result;
    }
}
