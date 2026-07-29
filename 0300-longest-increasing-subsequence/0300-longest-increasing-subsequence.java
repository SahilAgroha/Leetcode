class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        if(n==0 || n==1){
            return n;
        }
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
        }

        int ans=1;

        for(int i=1;i<n;i++){
            for(int j=0;j<=i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}