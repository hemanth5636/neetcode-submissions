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
    TreeNode result;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    private int dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return 0;

        int left = dfs(root.left, p, q);
        int right = dfs(root.right, p, q);
        int isCurr = (root.val == p.val || root.val == q.val) ? 1 : 0;

        if (result == null && left + right + isCurr >= 2) result = root;

        return Math.max(left, Math.max(right, isCurr));

    }
}
