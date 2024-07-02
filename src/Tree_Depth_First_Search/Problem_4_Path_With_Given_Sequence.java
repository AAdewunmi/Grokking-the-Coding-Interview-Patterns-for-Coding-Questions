package Tree_Depth_First_Search;

// Problem Statement: Path With Given Sequence (medium)
// LeetCode Question: -

public class Problem_4_Path_With_Given_Sequence {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int value) {
            int val = value;
        }
    }

    public boolean findPath (TreeNode root, int[] sequence){
        if (root == null) return sequence.length == 0;
        return findPathRecursive(root, sequence, 0);
    }

    private static boolean findPathRecursive(TreeNode currentNode, int[] sequence, int sequenceIndex) {
        if (currentNode == null) return false;
        if (sequenceIndex >= sequence.length || currentNode.val != sequence[sequenceIndex]) return false;
        if (currentNode.left == null && currentNode.right == null && sequenceIndex == sequence.length - 1) return true;
        return findPathRecursive(currentNode.left, sequence, sequenceIndex + 1) ||
                findPathRecursive(currentNode.right, sequence, sequenceIndex + 1);
    }

}
