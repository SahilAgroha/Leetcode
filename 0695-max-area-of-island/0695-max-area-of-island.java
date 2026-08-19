class Solution {
    private int dfs(int[][] grid, int sr, int sc){
        if(sr<0 || sr>=grid.length || sc<0 || sc>=grid[0].length || grid[sr][sc]!=1){
            return 0;
        }
        grid[sr][sc]=0;
        int left=dfs(grid,sr,sc-1);
        int right=dfs(grid,sr,sc+1);
        int top=dfs(grid,sr-1,sc);
        int bottom=dfs(grid,sr+1,sc);

        return left+right+top+bottom +1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }
}