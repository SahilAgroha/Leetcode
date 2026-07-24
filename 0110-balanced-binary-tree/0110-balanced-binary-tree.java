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
        if(root==null){
            return true;
        } 
        if(root.left==null && root.right==null){
            root.val=1;
        }
        boolean left=isBalanced(root.left);
        boolean right=isBalanced(root.right);

        int l=(root.left==null?0:root.left.val);
        int r=(root.right==null?0:root.right.val);
        
        if(Math.abs(l-r)>1){
            return false;
        }
        root.val=Math.max(l,r)+1;

        

        return left && right;
    }
}