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
    private void helper(TreeNode root, Queue<TreeNode> list){
        if(root==null){
            return;
        }
        list.add(root);
        helper(root.left,list);
        helper(root.right,list);
        root.left=null;
    }
    public void flatten(TreeNode root) {
        if(root==null){
            return ;
        }
        Queue<TreeNode> list=new LinkedList<>();
        helper(root,list);

        TreeNode prev=list.remove();
        
        
        while(!list.isEmpty()){
            TreeNode curr=list.remove();
            prev.right=curr;
            curr.left=null;
            prev=curr;

        }

    }
}