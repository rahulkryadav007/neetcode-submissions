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

    int count = 0;
    int result = 0;

    public int kthSmallest(TreeNode root, int k) {

        inorder(root, k);

        return result;
    }

    private void inorder(TreeNode root, int k) {

        if (root == null) {
            return;
        }

        // Visit left subtree
        inorder(root.left, k);

        // Visit current node
        count++;

        if (count == k) {
            result = root.val;
            return;
        }

        // Visit right subtree
        inorder(root.right, k);
    }
}

