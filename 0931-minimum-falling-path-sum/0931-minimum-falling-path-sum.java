class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;

        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int left=Integer.MAX_VALUE;
                int right=Integer.MAX_VALUE;
                int top=matrix[i-1][j];
                if(j>0){
                    left=matrix[i-1][j-1];
                }  
                if(j<n-1){
                    right=matrix[i-1][j+1];
                }
                matrix[i][j]+=Math.min(top,Math.min(left,right));
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min=Math.min(min,matrix[n-1][i]);
        }

        return min;
    }
}