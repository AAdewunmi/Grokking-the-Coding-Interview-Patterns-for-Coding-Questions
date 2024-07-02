package Tree_Depth_First_Search;

// Problem Statement: Binary Tree Path Sum (easy)
// LeetCode Question: 112. Path Sum

public class Problem_1_Binary_Tree_Path_Sum {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode (int val) {
            this.val = val;
        }
    }

    public static boolean hasPath (TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null)
            return true;
        return hasPath(root.left, sum - root.val) ||
                hasPath(root.right, sum - root.val);
    }

}
