class Solution {
    public int trap(int[] height) {
        int start=0;
        int end=height.length-1;
        int left=0; 
        int right=0;
        int ans=0;

        while(start<=end){
            left=Math.max(height[start],left);
            right=Math.max(height[end],right);
            if(left<right){
                ans+=left-height[start];
                start++;
            } else {
                ans+=right-height[end];
                end--;
            }
        }
        return ans;
    }
}