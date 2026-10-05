class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    private void createGraph(List<List<Integer>> connections,List<Integer>[] graph){
        for(int i=0;i<connections.size();i++){
            int curr=connections.get(i).get(0);
            int neigh=connections.get(i).get(1);
            graph[curr].add(neigh);
            graph[neigh].add(curr);
        }
    }
    private void dfs(List<Integer>[] graph, int curr, int par,int[] dt, int[] low, int time,boolean[] vis){
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        for(int i=0;i<graph[curr].size();i++){
            int neigh=graph[curr].get(i);
            if(neigh==par){
                continue;
            } else if(!vis[neigh]){
                dfs(graph,neigh,curr,dt,low,time,vis);
                low[curr]=Math.min(low[curr],low[neigh]);

                if(dt[curr]<low[neigh]){
                    ans.add(Arrays.asList(curr,neigh));
                }
            }  else {
                low[curr]=Math.min(low[curr],dt[neigh]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        createGraph(connections,graph);

        int dt[]=new int[n];
        int low[]=new int[n];
        int time=0;
        boolean[] vis=new boolean[n];
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(graph,i,-1,dt,low,time,vis);
            }
        }
        return ans;
    }
}