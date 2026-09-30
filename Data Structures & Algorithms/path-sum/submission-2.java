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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, targetSum, new int[1]);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int[] totalSum) {
        if (root == null) {
            return false;
        }
        int sum = totalSum[0] + root.val;
        if (sum == targetSum && root.left == null && root.right == null) {
            totalSum[0] = sum;
            return true;
        } else {
            totalSum[0] = sum;
        } 
        if (root.left != null && hasPathSum(root.left, targetSum, totalSum)) {
            return true;
        }
        if (root.right != null && hasPathSum(root.right, targetSum, totalSum)) {
            return true;
        }
        totalSum[0]-=root.val;
        return false;
    }
}