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
        int sum;
        int fac;
        Info(int s, int f){
            this.sum=s;
            this.fac=f;
        }
    }
    private Info helper(TreeNode root ){
        if(root==null){
            return new Info(0,0);
        }
        if(root.left==null && root.right==null){
            return new Info(root.val, 10);
        }

        Info left=helper(root.left);
        Info right=helper(root.right);

        int fac=left.fac+right.fac;
        int sum=left.sum+right.sum+root.val*fac;

        return new Info(sum, fac*10);


    }
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }

        return helper(root).sum;
    }
}