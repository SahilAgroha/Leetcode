class Solution {
    public int maximumProduct(int[] nums) {
        

        Arrays.sort(nums);
        int i=nums.length-1;
        int first=nums[0]*nums[1]*nums[i];
        int last=nums[i]*nums[i-1]*nums[i-2];
        return Math.max(first,last);
    }
}