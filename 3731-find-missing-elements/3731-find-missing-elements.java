class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        int min=nums[0];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            while(min<nums[i]){
                ans.add(min);
                min++;
            }
            min++;
        }

        return ans;
    }
}