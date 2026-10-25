class Solution {
    private void close(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=0){
            return ;
        }
        grid[i][j]=1;
        close(grid,i-1,j);
        close(grid,i+1,j);
        close(grid,i,j-1);
        close(grid,i,j+1);
    }
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            if(grid[i][0]==0){
                close(grid,i,0);
            }
            if(grid[i][m-1]==0){
                close(grid,i,m-1);
            }
        }

        for(int j=0;j<m;j++){
            if(grid[0][j]==0){
                close(grid,0,j);
            }
            if(grid[n-1][j]==0){
                close(grid,n-1,j);
            }
        }
        int ans=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(grid[i][j]==0){
                    ans++;
                    close(grid,i,j);
                }
            }
        }

        return ans;
    }
}