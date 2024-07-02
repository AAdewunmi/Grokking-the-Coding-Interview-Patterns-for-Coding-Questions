package Tree_Depth_First_Search;

// Problem Statement: Sum of Path Numbers (medium)
// LeetCode Question: 129. Sum Root to Leaf Numbers

public class Problem_3_Sum_Of_Path_Numbers {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int val) {
            this.val = val;
        }
    }

    public int findSumOfPathNumbers(TreeNode root){
        return findRootToLeafPathNumbers(root, 0);
    }

    private int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
        if (currentNode == null) return 0;
        pathSum = 10 * pathSum + currentNode.val;
        if (currentNode.left == null && currentNode.right == null) return pathSum;
        return findRootToLeafPathNumbers(currentNode.left, pathSum) + findRootToLeafPathNumbers(currentNode.right, pathSum);
    }
    
}
