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


        int c = root.val == p.val || root.val == q.val ? 1 : 0;

        int l = dfs(root.left, p, q);
        int r = dfs(root.right, p, q);

        if (l + r + c == 2 && result == null) {
            result = root;
            return 2;
        }

        return l + r + c;
    }
}
