package Concurrency;

// Problem Statement: Invert Binary Tree (medium)
// LeetCode Question: 226. Invert Binary Tree

public class Problem_2_Invert_Binary_Tree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        return root;
    }
}
