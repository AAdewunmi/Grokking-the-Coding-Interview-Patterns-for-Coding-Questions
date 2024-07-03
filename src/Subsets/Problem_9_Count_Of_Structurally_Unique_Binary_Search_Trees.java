package Subsets;

// Problem Statement: Count of Structurally Unique Binary Search Trees
// LeetCode Question: 96. Unique Binary Search Trees

import java.util.HashMap;
import java.util.Map;

public class Problem_9_Count_Of_Structurally_Unique_Binary_Search_Trees {

    class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;

       TreeNode(int x) {
         val = x;
       }
    };

    Map<Integer, Integer> map = new HashMap<>();

    public int countTrees(int n) {
        if (map.containsKey(n))
            return map.get(n);

        if (n <= 1)
            return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int countOfLeftSubtrees = countTrees(i - 1);
            int countOfRightSubtrees = countTrees(n - i);
            count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        map.put(n, count);
        return count;
    }

}
