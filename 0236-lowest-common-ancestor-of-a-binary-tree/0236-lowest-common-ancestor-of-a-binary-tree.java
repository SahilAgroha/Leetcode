class Solution {

    private boolean path(TreeNode root, TreeNode node, ArrayList<TreeNode> list){
        if(root == null) return false;

        list.add(root);

        if(root == node) return true;

        if(path(root.left, node, list) || path(root.right, node, list))
            return true;

        list.remove(list.size() - 1);
        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> l1 = new ArrayList<>();
        ArrayList<TreeNode> l2 = new ArrayList<>();

        path(root, p, l1);
        path(root, q, l2);

        int i = 0;
        while(i < l1.size() && i < l2.size() && l1.get(i) == l2.get(i)){
            i++;
        }

        return l1.get(i - 1);
    }
}