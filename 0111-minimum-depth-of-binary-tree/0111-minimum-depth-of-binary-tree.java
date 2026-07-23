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
    public int minDepthHelp(TreeNode root) {
        if(root==null){
            return Integer.MAX_VALUE;
        } else if(root.left==null && root.right==null){
            return 1;
        }
        int left=minDepthHelp(root.left);
        int right=minDepthHelp(root.right);

        return Math.min(left,right)+1;
    }

    public int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        return minDepthHelp(root);
    }
}