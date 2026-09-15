class Solution {
    private int helper(int n , int[] way){
        if(n==0 || n==1){
            return way[n]=1;
        }
        if(way[n-1]==0){
            way[n-1]=helper(n-1,way);
        }
        if(way[n-2]==0){
            way[n-2]=helper(n-2,way);
        }
        return way[n]=way[n-1]+way[n-2];
    }
    public int climbStairs(int n) {
        int way[]=new int[n+1];
        return helper(n,way);
    }

}