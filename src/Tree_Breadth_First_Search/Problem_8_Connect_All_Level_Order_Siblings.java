package Tree_Breadth_First_Search;

// Problem Statement: Connect All Level Order Siblings (medium)
// LeetCode Question: -

import java.util.LinkedList;
import java.util.Queue;

public class Problem_8_Connect_All_Level_Order_Siblings {

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode next;

        public TreeNode() {}

        public TreeNode(int x) {
            this.val = val;
            this.left = this.right = this.next = null;
        }
    }

    public TreeNode connect (TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode currentNode = null, previousNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (previousNode != null) {
                previousNode.next = currentNode;
            }
            previousNode = currentNode;
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
        return root;
    }

}
