class Solution {
    class Edge{
        int u;
        int v;
        int w;
        Edge(int u, int v, int w){
            this.u=u; 
            this.v=v;
            this.w=w;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int[] t:times){
            graph[t[0]-1].add(new Edge(t[0]-1,t[1]-1, t[2] ));
        }
        k--;
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            if(i!=k){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        q.offer(k);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(Edge e:graph[curr]){
                if(dist[curr]+e.w<dist[e.v]){
                    dist[e.v]=dist[curr]+e.w;
                    q.offer(e.v);
                }
            }
        }

        int max=dist[0];
        for(int i=1;i<n;i++){
            max=Math.max(max,dist[i]);
        }

        return max==Integer.MAX_VALUE?-1:max;

    }
}