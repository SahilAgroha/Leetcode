class Solution {
    class Edge{
        int des;
        double prob;
        Edge(int d, double p){
            this.des=d;
            this.prob=p;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        boolean[] vis=new boolean[n];
        int m=edges.length;
        List<Edge>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double p=succProb[i];
            graph[u].add(new Edge(v,p));
            graph[v].add(new Edge(u,p));
        }
        double[] reach=new double[n];
        reach[start]=1;
        Queue<Integer> q=new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<graph[curr].size();i++){
                Edge next=graph[curr].get(i);
                if(reach[curr]*(next.prob)>reach[next.des]){
                    reach[next.des]=reach[curr]*(next.prob);
                    q.offer(next.des);
                }
            }
        }

        return reach[end];
    }
}