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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        dfs(root, val);
        return root;
    }

    private void dfs(TreeNode root, int val) {
        if (root == null) return;

        if (val < root.val) {
            if (root.left == null) {
                TreeNode nn = new TreeNode(val);
                root.left = nn;
                return;
            } else {
                dfs(root.left, val);
            }
        } else {
            if (root.right == null) {
                TreeNode nn = new TreeNode(val);
                root.right = nn;
                return;
            } else {
                dfs(root.right, val);
            }
        }
    }
}