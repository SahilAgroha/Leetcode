class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                dp[i][j]=triangle.get(i).get(j);
            }
        }

        for(int i=1;i<n;i++){
            dp[i][0]+=dp[i-1][0];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<=i;j++){
                dp[i][j]+=Math.min(dp[i-1][j],dp[i-1][j-1]);
            }
        }

        int min=Integer.MAX_VALUE;

        for(int j=0;j<n;j++){
            min=Math.min(min, dp[n-1][j]);
        }

        return min;
    }
}