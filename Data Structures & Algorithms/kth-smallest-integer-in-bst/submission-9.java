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
    int result = -1;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return result;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;

        if (root.left != null) {
            dfs(root.left);
        }

        if (result != -1) return;

        k--;

        if (k == 0) result = root.val;
        else dfs(root.right);
    }
}
