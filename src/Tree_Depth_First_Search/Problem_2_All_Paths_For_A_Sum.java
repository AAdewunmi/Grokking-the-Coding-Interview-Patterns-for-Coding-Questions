package Tree_Depth_First_Search;

// Problem Statement: All Paths for a Sum (medium)
// LeetCode Question: 113. Path Sum II

import java.util.ArrayList;
import java.util.List;

public class Problem_2_All_Paths_For_A_Sum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> findPaths (TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();
        findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive (TreeNode currentNode, int sum,
                                            List<Integer> currentPath,
                                            List<List<Integer>> allPaths) {
        if (currentNode == null) return;
        currentPath.add(currentNode.val);
        if (currentNode.val == sum && currentNode.left == null
            && currentNode.right == null) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } else {
            findPathsRecursive(currentNode.left, sum - currentNode.val, currentPath, allPaths);
            findPathsRecursive(currentNode.right, sum - currentNode.val, currentPath, allPaths);
        }
        currentPath.remove(currentPath.size() - 1);
    }

}
