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
    int idx=0;
    private TreeNode helper(int[] preorder, int start, int end , HashMap<Integer,Integer> map){
        if(start>end){
            return null;
        }
        int val=preorder[idx++];
        TreeNode node=new TreeNode(val);
        int index=map.get(val);
        node.left=helper(preorder,start,index-1,map);
        node.right=helper(preorder,index+1, end, map);

        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,0,inorder.length-1, map);
    }
}