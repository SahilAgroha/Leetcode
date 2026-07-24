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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> ans=new ArrayList<>();
        LinkedList<Integer> level=new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean reverse=false;
        while(!q.isEmpty()){
            TreeNode curr=q.remove();
            if(curr==null){
                reverse=!reverse;
                ans.add(level);
                level=new LinkedList<>();

                if(q.isEmpty()){
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if(reverse){
                    level.addFirst(curr.val);
                } else {
                    level.addLast(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }

        return ans;
    }
}