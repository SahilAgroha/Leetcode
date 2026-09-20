/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
   int getindex(vector<int>& preorder, vector<int>& inorder, int &index){
    int ind=-1;
    for(int i=0;i<inorder.size();i++){
        if(inorder[i]==preorder[index]){
            return i;
        }
    }
    return ind;
   }
    TreeNode *f(vector<int>& preorder, vector<int>& inorder,int s, int e, int &index){
        if(index>=preorder.size()){
            return NULL;
        }
        if(s>e){
            return NULL;
        }
        
        TreeNode *root=new TreeNode(preorder[index]);
        int mid=getindex(preorder,inorder,index);
        index++;
        root->left=f(preorder,inorder,s,mid-1,index);
        root->right=f(preorder,inorder,mid+1,e,index);
        return root;
    }
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int index=0;
        int n=inorder.size()-1;
        return f(preorder,inorder,0,n,index);
    }
};