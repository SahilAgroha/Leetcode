class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=nums[0];
        for(int num : nums){
            max=Math.max(max, num);
        }

        int freq[]=new int[max+1];
        for(int num: nums){
            freq[num]++;
        }
        int dp[]=new int[max+1];
        dp[0]=0;
        dp[1]=freq[1];
        for(int i=2;i<=max;i++){
            dp[i]=Math.max(dp[i-1], dp[i-2]+i*freq[i]);
        }

        return dp[max];
    }
}