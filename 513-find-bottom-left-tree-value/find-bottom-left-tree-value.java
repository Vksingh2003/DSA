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
    int maxDepth = -1;
    int ans = 0;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return ans;
    }

    void dfs(TreeNode node, int depth) {
        if(node == null) return;

        if(depth > maxDepth) {
            maxDepth = depth;
            ans = node.val;
        }

        dfs(node.left, depth + 1);   // LEFT first
        dfs(node.right, depth + 1);
    }
}
