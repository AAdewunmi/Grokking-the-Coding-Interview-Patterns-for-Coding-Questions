package Tree_Breadth_First_Search;

// Problem Statement: Level Order Successor (easy)
// LeetCode Question: -

import java.util.LinkedList;
import java.util.Queue;

public class Problem_6_Level_Order_Successor {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = x;
        }
    }

    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);
            if (currentNode.val == key) break;
        }
        return queue.peek();
    }

}
