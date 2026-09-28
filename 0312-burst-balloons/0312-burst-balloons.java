class Solution {
    private int helper(int start, int end , int[] arr,int[][] dp){
        if(start>end){
            return 0;
        }
        if(dp[start][end]!=-1){
            return dp[start][end];
        }
        int max=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            int cost=arr[start-1]*arr[i]*arr[end+1]+helper(start,i-1,arr,dp)+helper(i+1,end,arr,dp);
            max=Math.max(max,cost);
        }

        return dp[start][end]=max;
    }
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int arr[]=new int[n+2];
        arr[0]=arr[n+1]=1;
        for(int i=0;i<n;i++){
            arr[i+1]=nums[i];
        }

        int dp[][]=new int[n+2][n+2];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }

        return helper(1,n,arr,dp);
    }
}