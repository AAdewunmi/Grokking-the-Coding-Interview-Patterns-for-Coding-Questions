package Concurrency;

// Problem Statement: Same Tree (medium)
// LeetCode Question: 100. Same Tree

public class Problem_1_Same_Tree {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        // one of p and q has different value
        if (p.val != q.val) return false;

        // check left and right subtree recursively
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }

}
