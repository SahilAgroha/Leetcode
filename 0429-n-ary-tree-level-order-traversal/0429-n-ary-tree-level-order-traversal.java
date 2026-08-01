/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null){
            return ans;
        }

        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> level=new ArrayList<>();
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                ans.add(new ArrayList<>(level));
                level=new ArrayList<>();
                if(!q.isEmpty()){
                    q.add(null);
                }
            } else {
                level.add(curr.val);
                for(int i=0;i<curr.children.size();i++){
                    q.add(curr.children.get(i));
                }
            }
        }

        return ans;
    }
}