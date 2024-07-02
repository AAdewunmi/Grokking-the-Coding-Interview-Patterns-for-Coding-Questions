package Tree_Breadth_First_Search;

// Problem Statement: Minimum Depth of a Binary Tree (easy)
// LeetCode Question: 111. Minimum Depth of Binary Tree

import java.util.LinkedList;
import java.util.Queue;

public class Problem_5_Minimum_Depth_Of_A_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = x;
        }
    }

    public int findDepth ( TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minimumTreeDepth = 0;
        while (!queue.isEmpty()) {
            minimumTreeDepth++;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode.left == null && currentNode.right == null) return minimumTreeDepth;
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
        }
        return minimumTreeDepth;
    }
}
