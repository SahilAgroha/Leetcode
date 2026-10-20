class Solution {
    private void swap(int[] nums, int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    private void reverse(int[] nums, int idx){
        int end=nums.length-1;
        while(idx<end){
            swap(nums,end--,idx++);
        }
    }
    public void nextPermutation(int[] nums) {
        int idx1=-1;
        int idx2=-2;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx1=i;
                break;
            }
        }
        if(idx1==-1){
            reverse(nums,0);
        } else {
            for(int i=nums.length-1;i>=0;i--){
                if(nums[i]>nums[idx1]){
                    idx2=i;
                    break;
                }
            }
            swap(nums,idx1,idx2);
            reverse(nums,idx1+1);
        }
    }
}