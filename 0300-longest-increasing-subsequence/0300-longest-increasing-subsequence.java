class Solution {
    private int lcs(int arr1[], int arr2[]){
        int n=arr1.length;
        int m=arr2.length;

        int dp[][]=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                } else {
                    dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public int lengthOfLIS(int[] nums) {
        
        HashSet<Integer> set=new HashSet<>();
        for(int x: nums){
            set.add(x);
        }
        int arr[]=new int[set.size()];

        int i=0;
        for(int x: set){
            arr[i]=x;
            i++;
        }

        Arrays.sort(arr);

        return lcs(nums, arr);

    }
}