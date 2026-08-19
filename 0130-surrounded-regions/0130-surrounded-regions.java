class Solution {
    private void dfs(char[][] grid, int r, int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]!='O'){
            return ;
        }
        grid[r][c]='#';
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
    }
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        for(int i=0;i<n;i++){
            dfs(board, i, m-1);
            dfs(board,i, 0);
        }

        for(int j=0;j<m;j++){
            dfs(board,0,j);
            dfs(board,n-1,j);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                } else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
}