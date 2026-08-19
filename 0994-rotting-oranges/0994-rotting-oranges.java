class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                } else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int min=0;
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int size=queue.size();
            boolean infacted=false;

            for(int i=0;i<size;i++){
                int[] curr=queue.poll();

                for(int[] d:dir){
                    int r=curr[0]+d[0];
                    int c=curr[1]+d[1];
                    if(r>=0 && r<n && c>=0 && c<m && grid[r][c]==1){
                        grid[r][c]=2;
                        infacted=true;
                        queue.offer(new int[]{r, c});
                        fresh--;
                    }
                }
            }
            if(infacted){
                min++;
            }
        }
        return fresh==0?min:-1;
    }
}