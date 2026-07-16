class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        nums[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int step=nums[i];
            int min=nums[i+1];
            int j=2;
            while(i+j<n && j<=step){
                min=Math.min(nums[i+j],min);
                j++;
            }
            nums[i]=min+1;
        }

        return nums[0];
    }
}