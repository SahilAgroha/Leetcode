class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean[] vis=new boolean[n];
        vis[n-1]=true;

        for(int i=n-2;i>=0;i--){
            int step=nums[i];
            int j=1;
            while(i+j<n && j<=step){
                if(vis[i+j]){
                    vis[i]=true;
                    break ;
                }
                j++;
            }
        }
        return vis[0];
    }
}