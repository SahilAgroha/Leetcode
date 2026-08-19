class Solution {
    private void dfs(int[][] grid , int r, int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]==0){
            return ;
        }
        grid[r][c]=0;
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
    }
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0;i<n;i++){
            dfs(grid,i,m-1);
            dfs(grid,i,0);
        }

        for(int j=0;j<m;j++){
            dfs(grid,0,j);
            dfs(grid,n-1,j);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}