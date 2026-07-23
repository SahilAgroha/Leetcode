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
    private boolean isSame(TreeNode p,  TreeNode q){
        if(p==null && q==null){
            return true;
        } else if (p==null || q==null){
            return false;
        } else if(q.val!=p.val){
            return false ;
        }

        return isSame(p.left, q.right) && isSame(p.right, q.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }

        return isSame(root.left, root.right);
    }
}