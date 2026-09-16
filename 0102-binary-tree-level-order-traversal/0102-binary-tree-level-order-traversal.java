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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> level=new ArrayList<>();
        q.offer(root);
        q.offer(null);

        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null){
                ans.add(new ArrayList<>(level));
                level=new ArrayList<>();
                if(!q.isEmpty()){
                    q.offer(null);
                }
            } else {
                level.add(curr.val);
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
            }
        }
        return ans;
    }
}