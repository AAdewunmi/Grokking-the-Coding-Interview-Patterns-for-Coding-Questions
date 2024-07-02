package Tree_Depth_First_Search;

// Problem Statement: Count Paths for a Sum (medium)
// LeetCode Question: 437. Path Sum III

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Problem_5_Count_Paths_For_A_Sum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = x;
        }
    }

    public int countPaths (TreeNode root, int S) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursive(root, S, currentPath);
    }

    private static int countPathsRecursive(TreeNode currentNode, int S, List<Integer> currentPath) {
        if (currentNode == null) return 0;
        currentPath.add(currentNode.val);
        int pathCount = 0;
        double pathSum = 0;
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            pathSum += pathIterator.previous();
            if (pathSum == S) pathCount++;
        }
        pathCount += countPathsRecursive(currentNode.left, S, currentPath);
        pathCount += countPathsRecursive(currentNode.right, S, currentPath);
        currentPath.remove(currentPath.size() - 1);
        return pathCount;
    }

}
