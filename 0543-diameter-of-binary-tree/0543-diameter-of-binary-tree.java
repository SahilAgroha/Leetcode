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
    class Info{
        int ht;
        int dia;
        Info(int h, int d){
            this.ht=h;
            this.dia=d;
        }
    }
    private Info helper(TreeNode root){
        if(root==null){
            return new Info(0,0);
        }

        Info left=helper(root.left);
        Info right=helper(root.right);
        int ht=Math.max(left.ht, right.ht)+1;

        int dia=Math.max(left.ht+right.ht+1,Math.max(left.dia, right.dia));

        return new Info(ht,dia);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return helper(root).dia-1;
    }
}