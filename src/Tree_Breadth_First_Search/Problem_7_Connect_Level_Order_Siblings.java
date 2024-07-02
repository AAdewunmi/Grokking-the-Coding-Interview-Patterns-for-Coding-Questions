package Tree_Breadth_First_Search;

// Problem Statement: Connect Level Order Siblings (medium)
// LeetCode Question: 116. Populating Next Right Pointers in Each TreeNode

import java.util.LinkedList;
import java.util.Queue;

public class Problem_7_Connect_Level_Order_Siblings {
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

    public TreeNode connect(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode previousNode = null;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
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
        }
        return root;
    }

    public static void printLevelOrder(TreeNode root) {
        TreeNode nextLevelRoot = root;
        while (nextLevelRoot != null) {
            TreeNode current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null)
                        nextLevelRoot = current.left;
                    else if (current.right != null)
                        nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}
