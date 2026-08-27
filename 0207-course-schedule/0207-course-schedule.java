class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] graph=new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        int[] indeg=new int[n];

        for(int[] pre:prerequisites){
            indeg[pre[0]]++;
            graph[pre[1]].add(pre[0]);
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }

        int comp=0;
        while(!q.isEmpty()){
            comp++;
            int curr=q.poll();

            for(int next:graph[curr]){
                indeg[next]--;
                if(indeg[next]==0){
                    q.offer(next);
                }
            }
        }

        return comp==n;
    }
}