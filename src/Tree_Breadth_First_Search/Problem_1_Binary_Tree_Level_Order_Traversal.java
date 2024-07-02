package Tree_Breadth_First_Search;

// Problem Statement: Binary Tree Level Order Traversal (easy)
// LeetCode Question: 102. Binary Tree Level Order Traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_1_Binary_Tree_Level_Order_Traversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){
            this.val = x;
        }
    }

    public List<List<Integer>> traverse (TreeNode root){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }
}
