class Solution {
    private int lis(int[] num1, int[] num2){
        int n=num1.length;
        int m=num2.length;
        int dp[][]=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(num1[i-1]==num2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                } else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int nums2[]=new int[set.size()];
        int i=0;
        for(int x: set){
            nums2[i++]=x;
        }

        Arrays.sort(nums2);

        return lis(nums,nums2);
    }
}