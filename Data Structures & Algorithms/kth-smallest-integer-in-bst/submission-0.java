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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        inordersearch(root, ls);
        return ls.get(k - 1);
    }

    private void inordersearch(TreeNode root, List<Integer> vals) {
        if(root == null) return;
        inordersearch(root.left, vals);
        vals.add(root.val);
        inordersearch(root.right, vals);
    }
}
