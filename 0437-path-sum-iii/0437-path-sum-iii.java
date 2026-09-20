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
    int ans=0;
    private void helper(TreeNode root, int targetSum, HashMap<Long,Integer> map, long sum){
        if(root==null){
            return ;
        }
        sum+=root.val;
        ans+=map.getOrDefault(sum-targetSum,0);
        map.put(sum,map.getOrDefault(sum,0)+1);

        helper(root.left,targetSum,map,sum);
        helper(root.right,targetSum,map,sum);
        map.put(sum,map.get(sum)-1);

    }
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map=new HashMap<>();
        map.put(0L,1);
        helper(root,targetSum,map,0L);
        return ans;
    }
}