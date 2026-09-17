class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int inDeg[]=new int[n];
        int count=0;
        ArrayList<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] pre: prerequisites){
            inDeg[pre[0]]++;
            graph[pre[1]].add(pre[0]);
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDeg[i]==0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int curr=q.poll();
            count++;
            for(int next : graph[curr]){
                inDeg[next]--;
                if(inDeg[next]==0){
                    q.offer(next);
                }
            }
        }

        return count==n;

    }
}