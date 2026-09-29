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
    public boolean isBalanced(TreeNode root) {
        return getMaxHeightIfBalancedOrNegative(root) >= 0;
    }

    public int getMaxHeightIfBalancedOrNegative(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMaxHeightIfBalancedOrNegative(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getMaxHeightIfBalancedOrNegative(root.right);
        if(right == -1){
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : Math.max(right, left) + 1;
        
    }
}
