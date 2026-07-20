class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int x: nums){
            sum+=x;
        }

        if (Math.abs(target) > sum)
            return 0;

        if ((sum + target) % 2 != 0)
            return 0;

        target=(sum+target)/2;


        int dp[][]=new int[n+1][target+1];

        // for(int i=0;i<=n;i++){
        //     dp[i][0]=1;
        // }
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=target;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j]+=dp[i-1][j-nums[i-1]];
                }
            }
        }

        return dp[n][target];


        
    }
}