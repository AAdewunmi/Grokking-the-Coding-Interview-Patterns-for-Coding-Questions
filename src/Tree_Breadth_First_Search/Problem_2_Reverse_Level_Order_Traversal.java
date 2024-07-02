package Tree_Breadth_First_Search;

// Problem Statement: Reverse Level Order Traversal (easy)
// LeetCode Question: 107. Binary Tree Level Order Traversal II

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_2_Reverse_Level_Order_Traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val) {this.val = val;}
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrderBottom (TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            result.add(0, currentLevel);
        }
        return result;
    }
}
