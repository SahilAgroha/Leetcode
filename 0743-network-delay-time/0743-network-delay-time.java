class Solution {
    class Edge{
        int src;
        int des;
        int time;
        Edge(int s,int d, int t){
            this.src=s;
            this.des=d;
            this.time=t;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<Edge>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] t:times){
            int u=t[0]-1;
            int v=t[1]-1;
            int w=t[2];
            graph[u].add(new Edge(u,v,w));
        }
        k--;
        int[] time=new int[n];
        for(int i=0;i<n;i++){
            if(i!=k){
                time[i]=Integer.MAX_VALUE;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        q.offer(k);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<graph[curr].size();i++){
                Edge next=graph[curr].get(i);
                if(time[curr]+next.time<time[next.des]){
                    time[next.des]=time[curr]+next.time;
                    q.offer(next.des);
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,time[i]);
        }

        return max==Integer.MAX_VALUE?-1:max;
    }
}