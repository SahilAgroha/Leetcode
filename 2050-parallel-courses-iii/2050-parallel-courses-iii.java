class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int indeg[]=new int[n+1];

        List<Integer>[] graph=new ArrayList[n+1];

        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=0;i<relations.length;i++){
            indeg[relations[i][1]]++;
            graph[relations[i][0]].add(relations[i][1]);
        }

        Queue<Integer> q=new LinkedList<>();
        int[] finishTime=new int[n+1];
        for(int i=1;i<=n;i++){
            if(indeg[i]==0){
                q.offer(i);
                finishTime[i]=time[i-1];
            }
        }
        int max=0;
        int ans=0;
        while(!q.isEmpty()){
            Integer curr=q.poll();
                ans=Math.max(ans,finishTime[curr]);
                for(int next:graph[curr]){
                    finishTime[next]=Math.max(finishTime[next],finishTime[curr]+time[next-1]);
                    indeg[next]--;
                    if(indeg[next]==0){
                        q.offer(next);
                        
                    }
                }

        }
        return ans;
    }
}