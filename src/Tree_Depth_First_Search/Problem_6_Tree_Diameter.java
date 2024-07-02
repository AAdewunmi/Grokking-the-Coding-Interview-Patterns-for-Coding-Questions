package Tree_Depth_First_Search;

// Problem Statement: Tree Diameter (medium)
// LeetCode Question: 543. Diameter of Binary Tree

public class Problem_6_Tree_Diameter {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = x;
        }
    }

    private int treeDiameter = 0;

    public int findDiameter(TreeNode root){
        treeDiameter = 0;
        calculateHeight(root);
        return treeDiameter;
    }

    public int calculateHeight(TreeNode currentNode){
        if (currentNode == null) return 0;
        int leftTreeHeight = calculateHeight(currentNode.left);
        int rightTreeHeight = calculateHeight(currentNode.right);
        if (leftTreeHeight != 0 && rightTreeHeight != 0) {
            int diameter = leftTreeHeight + rightTreeHeight + 1;
            treeDiameter = Math.max(treeDiameter, diameter);
        }
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }
}
