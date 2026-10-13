class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        long[] sq=new long[n];
        long total=0;
        for(int i=0;i<n;i++){
            total+=sq[i]=(long) nums[i]*nums[i];
        }
        Arrays.sort(sq);
        for(int i=0;i<n/2;i++){
            total-=2*sq[i];
        }
        return total;
    }
}