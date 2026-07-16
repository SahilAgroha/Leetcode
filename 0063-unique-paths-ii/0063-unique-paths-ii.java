class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        dp[0][0] = grid[0][0] == 1 ? 0 : 1;

        // First column
        for(int i = 1; i < n; i++) {
            if(grid[i][0] == 1)
                dp[i][0] = 0;
            else
                dp[i][0] = dp[i-1][0];
        }

        // First row
        for(int j = 1; j < m; j++) {
            if(grid[0][j] == 1)
                dp[0][j] = 0;
            else
                dp[0][j] = dp[0][j-1];
        }

        // Remaining cells
        for(int i = 1; i < n; i++) {
            for(int j = 1; j < m; j++) {
                if(grid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[n-1][m-1];
    }
}