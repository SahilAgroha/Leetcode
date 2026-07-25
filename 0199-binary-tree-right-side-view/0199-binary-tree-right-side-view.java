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
    int max=-1;
    private void view(TreeNode root, int level, List<Integer> list ){
        if(root==null){
            return ;
        }
        if(level>max){
            list.add(root.val);
            max=level;
        }
        level++;
        view(root.right,level,list);
        view(root.left, level, list);

    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        view(root,0,ans);
        return ans;
    }
}