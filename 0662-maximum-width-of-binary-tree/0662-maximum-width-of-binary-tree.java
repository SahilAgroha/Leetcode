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
        TreeNode node;
        int idx;
        Info(TreeNode node, int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        int ans=0;
        if(root==null){
            return ans;
        }
        ans=1;
        Queue<Info> q=new LinkedList<>();
        q.offer(new Info(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int idx=0;
            int min=q.peek().idx;
            for(int i=0;i<size;i++){
                Info curr=q.poll();
                idx=curr.idx;

                if(curr.node.left!=null){
                    q.offer(new Info(curr.node.left, 2*idx));
                }
                if(curr.node.right!=null){
                    q.offer(new Info(curr.node.right,2*idx+1));
                }
            }
            ans=Math.max(ans,idx-min+1);
        }
        return ans;
    }
}