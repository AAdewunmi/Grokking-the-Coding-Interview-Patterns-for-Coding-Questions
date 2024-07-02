package Tree_Breadth_First_Search;

// Problem Statement: Zigzag Traversal (medium)
// LeetCode Question: 6. Zigzag Conversion


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_3_Zigzag_Traversal {
    class TreeNode  {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = left.val;
        }
    }
    public List<List<Integer>> traverse (TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (leftToRight) {
                    currentLevel.add(currentNode.val);
                } else {
                    currentLevel.add(0, currentNode.val);
                }
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return result;
    }
}
