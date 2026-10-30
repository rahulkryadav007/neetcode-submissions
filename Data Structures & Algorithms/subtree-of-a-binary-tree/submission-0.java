class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }

        // Check if both trees are same
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Search in left and right subtree
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both are null
        if (p == null && q == null) {
            return true;
        }

        // One is null
        if (p == null || q == null) {
            return false;
        }

        // Compare values and children
        return p.val == q.val &&
               isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}