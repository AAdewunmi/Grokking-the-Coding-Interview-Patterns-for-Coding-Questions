package Tree_Breadth_First_Search;

// Problem Statement: Right View of a Binary Tree (easy)
// LeetCode Question: 199. Binary Tree Right Side View

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_9_Right_View_Of_A_Binary_Tree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = x;
        }
    }

    public static List<Integer> traverse (TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (i == levelSize - 1){
                    result.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }
}
