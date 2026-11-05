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
        if(root == null) return true;
        return dfs(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean dfs(TreeNode node, int max, int min) {
        if(node == null) return true;
        return node.val > min && node.val < max && dfs(node.left, node.val, min) && dfs(node.right, max, node.val);
    }
}
