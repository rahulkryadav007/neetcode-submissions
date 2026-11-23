/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {

        // Base case
        if (node == null) {
            return 0;
        }

        // Calculate left and right maximum gains
        int left = Math.max(0, maxGain(node.left));
        int right = Math.max(0, maxGain(node.right));

        // Maximum path passing through current node
        int currentPathSum = node.val + left + right;

        // Update global maximum
        maxSum = Math.max(maxSum, currentPathSum);

        // Return maximum gain to parent
        return node.val + Math.max(left, right);
    }
}
