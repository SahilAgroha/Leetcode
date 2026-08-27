class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }

        int indeg[]=new int[n];
        for(int[] pre:prerequisites){
            indeg[pre[0]]++;
            graph[pre[1]].add(pre[0]);
        }
        Queue<Integer> q=new LinkedList<>();
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int i=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            ans[i++]=curr;
            for(int next: graph[curr]){
                indeg[next]--;
                if(indeg[next]==0){
                    q.offer(next);
                }
            }
        }
        if(i != n){
            return new int[0];
        }
        return ans;
    }
}