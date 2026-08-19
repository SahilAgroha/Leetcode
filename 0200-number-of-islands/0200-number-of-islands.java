class Solution {
    private void dfs(char[][] grid , int sr, int sc){
        if(sr<0 || sr>=grid.length ||  sc<0 || sc>=grid[0].length || grid[sr][sc]!='1'){
            return ;
        }
        grid[sr][sc]='0';
        dfs(grid,sr,sc+1);
        dfs(grid,sr+1,sc);
        dfs(grid,sr,sc-1);
        dfs(grid,sr-1,sc);
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    ans++;
                    dfs(grid,i,j);
                }
            }
        }

        return ans;
    }
}