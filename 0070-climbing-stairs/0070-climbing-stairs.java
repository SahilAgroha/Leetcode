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
    private int helper2(int n,int[] way){
        if(n==0 || n==1){
            return 1;
        }

        way[0]=way[1]=1;

        for(int i=2;i<=n;i++){
            way[i]=way[i-1]+way[i-2];
        }

        return way[n];
    }
    public int climbStairs(int n) {
        int way[]=new int[n+1];
        // return helper(n,way);
        return helper2(n,way);
    }

}