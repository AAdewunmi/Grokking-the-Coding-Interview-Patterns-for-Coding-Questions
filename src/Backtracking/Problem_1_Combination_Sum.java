package Backtracking;

// Problem Statement: Combination Sum (medium)
// LeetCode Question: 39. Combination Sum

import java.util.ArrayList;
import java.util.List;

public class Problem_1_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int start, int target, List<Integer> comb, List<List<Integer>> res){
        if (target == 0) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) {
                continue;
            }
            comb.add(candidates[i]);
            backtrack(candidates, i, target - candidates[i], comb, res);
            comb.remove(comb.size() - 1);
        }
    }
}
