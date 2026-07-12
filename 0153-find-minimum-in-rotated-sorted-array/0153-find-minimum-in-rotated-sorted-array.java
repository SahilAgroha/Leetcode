class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        int last=nums[end];

        int ans=Integer.MIN_VALUE;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]>last){
                start=mid+1;
            } else {
                end = mid;
            }
        }
        return nums[start];
    }
}