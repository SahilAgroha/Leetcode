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
    private TreeNode helper(int[] preorder, int s, int e, HashMap<Integer, Integer> map){
        if(s>e){
            return null;
        }
        int val=preorder[idx++];
        TreeNode root=new TreeNode(val);
        int index=map.get(val);
        root.left=helper(preorder,s,index-1,map);
        root.right=helper(preorder,index+1,e,map);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=preorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }

        return helper(preorder,0,n-1,map);
    }
}