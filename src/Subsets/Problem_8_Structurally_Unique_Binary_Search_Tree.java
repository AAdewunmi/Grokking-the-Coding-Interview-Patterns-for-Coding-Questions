package Subsets;

// Problem Statement: Structurally Unique Binary Search Trees (hard)
// LeetCode Question: 95. Unique Binary Search Trees II

import java.util.ArrayList;
import java.util.List;

public class Problem_8_Structurally_Unique_Binary_Search_Tree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> findUniqueTrees(int n) {
        if (n <= 0)
            return new ArrayList<TreeNode>();
        return findUniqueTreesRecursive(1, n);
    }

    public List<TreeNode> findUniqueTreesRecursive(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubtrees = findUniqueTreesRecursive(start, i - 1);
            List<TreeNode> rightSubtrees = findUniqueTreesRecursive(i + 1, end);
            for (TreeNode leftTree : leftSubtrees) {
                for (TreeNode rightTree : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    result.add(root);
                }
            }
        }
        return result;
    }

}
