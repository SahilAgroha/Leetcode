class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }

    // private int robUtil(int[] nums, int n){
    //     if(n==0){
    //         return 0;
    //     } else if(n==1){
    //         return nums[0];
    //     }
    //     int inc=robUtil(nums,n-2)+nums[n-1];
    //     int exc=robUtil(nums,n-1);
    //     return Math.max(inc,exc);
    // }
}