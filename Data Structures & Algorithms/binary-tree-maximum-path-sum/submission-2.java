class Solution {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxDown(root);
        return result;
    }

    // Returns: best sum of a straight DOWNWARD chain starting at this node.
    private int maxDown(TreeNode node) {
        if (node == null) return 0;

        // A negative chain is worse than no chain — clamp to 0 (i.e., don't extend that way).
        int l = Math.max(0, maxDown(node.left));
        int r = Math.max(0, maxDown(node.right));

        // Case A: this node as the TOP of a Λ — allowed to use both sides. Record it.
        result = Math.max(result, node.val + l + r);

        // Case B: what the parent may use — node + ONE side only.
        return node.val + Math.max(l, r);
    }
}