class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        boolean[] vis=new boolean[n];

        while(!q.isEmpty()){
            int curr=q.remove();
            vis[curr]=true;
            for(int i=0;i<rooms.get(curr).size();i++){
                int node=rooms.get(curr).get(i);
                if(!vis[node]){
                    q.add(node);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                return false;
            }
        }

        return true;
    }
}