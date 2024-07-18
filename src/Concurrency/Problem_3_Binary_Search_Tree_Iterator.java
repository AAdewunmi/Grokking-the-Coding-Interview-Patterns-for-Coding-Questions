package Concurrency;

// Problem Statement: Binary Search Tree Iterator (medium)
// LeetCode Question: 173. Binary Search Tree Iterator

import java.util.Stack;

public class Problem_3_Binary_Search_Tree_Iterator {

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

    private Stack<TreeNode> stack = new Stack<TreeNode>();

    public Problem_3_Binary_Search_Tree_Iterator(TreeNode root) {
        traverseLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tmpNode = stack.pop();
        traverseLeft(tmpNode.right);
        return tmpNode.val;
    }

    /** traverse the left sub-tree to push all nodes on the stack */
    private void traverseLeft(TreeNode node) {
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

}
