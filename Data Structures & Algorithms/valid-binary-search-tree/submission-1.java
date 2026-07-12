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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, 2000, -2000);
    }

    public boolean isValid(TreeNode root, int high, int low) {
        if (root == null) return true;

        if (root.val >= high || root.val <= low) return false;

        return isValid(root.left, root.val, low) && isValid(root.right, high, root.val);
    }
}
