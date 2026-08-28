class Solution {
    private void bfs(List<Integer>[] graph, int idx, boolean[] vis){
        Queue<Integer> q=new LinkedList<>();
        q.add(idx);
        while(!q.isEmpty()){
            int curr=q.poll();
            vis[curr]=true;
            for(int i=0;i<graph[curr].size();i++){
                int next=graph[curr].get(i);
                if(!vis[next]){
                    q.offer(next);
                }
            }
        }
    }
    private void dfs(List<Integer>[] graph, int idx, boolean[] vis){
        vis[idx]=true;

        for(int i=0;i<graph[idx].size();i++){
            int next=graph[idx].get(i);
            if(!vis[next]){
                dfs(graph,next,vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        List<Integer>[] graph=new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    graph[i].add(j);
                }
            }
        }

        boolean vis[]=new boolean[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans++;
                // dfs(graph,i,vis);
                bfs(graph,i,vis);
            }
        }

        return ans;
    }
}