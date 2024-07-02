package Tree_Depth_First_Search;

// Problem Statement: Path with Maximum Sum (hard)
// LeetCode Question: 124. Binary Tree Maximum Path Sum

public class Problem_7_Path_With_Maximum_Sum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = x;
        }
    }

    private static int globalMaximumSum;

    public int findMaximumPathSum(TreeNode root) {
        globalMaximumSum = Integer.MIN_VALUE;
        findMaximumPathSumRecursive(root);
        return globalMaximumSum;
    }

    private static int findMaximumPathSumRecursive(TreeNode currentNode){
        if (currentNode == null) return 0;
        int maxPathSumFromLeft = findMaximumPathSumRecursive(currentNode.left);
        int maxPathSumFromRight = findMaximumPathSumRecursive(currentNode.right);
        maxPathSumFromLeft = Math.max(maxPathSumFromLeft, 0);
        maxPathSumFromRight = Math.max(maxPathSumFromRight, 0);
        int localMaximumSum = maxPathSumFromLeft + maxPathSumFromRight + currentNode.val;
        globalMaximumSum = Math.max(globalMaximumSum, localMaximumSum);
        return Math.max(maxPathSumFromLeft, maxPathSumFromRight) + currentNode.val;
    }

}
