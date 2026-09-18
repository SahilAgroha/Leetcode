class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                else if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int dx[]=new int[]{1,0,-1,0};
        int dy[]=new int[]{0,1,0,-1};
        int ans=0;
        while(!q.isEmpty() && fresh > 0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] dxdy=q.poll();
                for(int j=0;j<4;j++){
                    int nx=dxdy[0]+dx[j];
                    int ny=dxdy[1]+dy[j];
                    if(nx<0 || nx>=n || ny<0 || ny>=m || grid[nx][ny]!=1){
                        continue ;
                    } else {
                        grid[nx][ny]=2;
                        q.offer(new int[]{nx,ny});
                        fresh--;
                    }
                }
            }
            ans++;
        }

        return fresh==0?ans:-1;
    }
}