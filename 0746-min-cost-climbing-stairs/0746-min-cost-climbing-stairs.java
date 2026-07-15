class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int dp[]=new int[n+2];
        
        for(int i=2;i<n+2;i++){
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i-2];
        }
        return Math.min(dp[n],dp[n+1]);
    }
}