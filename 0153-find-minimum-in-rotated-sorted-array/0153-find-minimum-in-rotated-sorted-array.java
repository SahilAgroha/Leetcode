class Solution {
    public int findMin(int[] nums) {
        int min=nums[0];
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]>=nums[left]){
                min=Math.min(min,nums[left]);
                left=mid+1;
            } else {
                min=Math.min(min,nums[mid]);
                right=mid;
            }
        }

        return min;
    }
}