class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();

        int dp[][]=new int[n+1][m+1];

        // if word1 is empty then we have to add char equal to char of word2
        for(int j=1;j<=m;j++){
            dp[0][j]=j;
        }

        // if word2 is empty then we have to delete char equal to char left in word1
        for(int i=1;i<=n;i++){
            dp[i][0]=i;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                } else {
                    //  dp[i-1][j-1]   replace 
                    // dp[i-1][j]   delete 
                    // dp[i][j-1]  add
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }

        return dp[n][m];

    }
}