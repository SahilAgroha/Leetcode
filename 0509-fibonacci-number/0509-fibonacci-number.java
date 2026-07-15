class Solution {
    public int fib(int n) {
        int dp[]=new int[n+1];
        
        return fibUtil(n,dp);
    }

    private int fibUtil(int n, int[] dp){
        if(n==0 || n==1){
            return dp[n]=n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int n1=fibUtil(n-1,dp);
        int n2=fibUtil(n-2,dp);
        return dp[n]=n1+n2;
    }
}