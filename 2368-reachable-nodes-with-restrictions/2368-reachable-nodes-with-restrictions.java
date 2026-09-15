class Solution {
    int ans=0;
    private void helper(ArrayList<Integer>[] tree, boolean[] vis, int idx){
        vis[idx]=true;
        ans++;
        for(int i=0;i<tree[idx].size();i++){
            int des=tree[idx].get(i);
            if(!vis[des]){
                helper(tree,vis,des);
            }
        }
    }
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        ArrayList<Integer>[] tree=new ArrayList[n];
        for(int i=0;i<n;i++){
            tree[i]=new ArrayList<>();
        }

        for(int[] e: edges){
            tree[e[0]].add(e[1]);
            tree[e[1]].add(e[0]);
        }
        boolean[] vis=new boolean[n];
        for(int res : restricted){
            vis[res]=true;
        }

        helper(tree,vis,0);

        return ans;

    }
}