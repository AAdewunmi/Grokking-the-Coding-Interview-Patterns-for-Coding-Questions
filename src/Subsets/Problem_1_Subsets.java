package Subsets;

// Problem Statement: Subsets (easy)
// LeetCode Question: 78. Subsets

import java.util.ArrayList;
import java.util.List;

public class Problem_1_Subsets {

    public List<List<Integer>> findSubset (int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }

}
