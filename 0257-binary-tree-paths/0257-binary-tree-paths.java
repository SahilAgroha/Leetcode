class Solution {

    private void helper(TreeNode root, List<String> ans, StringBuilder sb) {
        if (root == null) {
            return;
        }

        int len = sb.length();

        if (len != 0) {
            sb.append("->");
        }

        sb.append(root.val);

        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
        } else {
            helper(root.left, ans, sb);
            helper(root.right, ans, sb);
        }

        sb.setLength(len);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root, ans, new StringBuilder());
        return ans;
    }
}