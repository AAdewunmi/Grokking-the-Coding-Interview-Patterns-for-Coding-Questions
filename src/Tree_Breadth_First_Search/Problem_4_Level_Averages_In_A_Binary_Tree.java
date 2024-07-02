package Tree_Breadth_First_Search;

// Problem Statement: Level Averages in a Binary Tree (easy)
// LeetCode Question: 637. Average of Levels in Binary Tree

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_4_Level_Averages_In_A_Binary_Tree {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = x;
        }
    }

    public List<Double> findLevelAverages (TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double levelSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            result.add(levelSum / levelSize);
        }
        return result;
    }

}
