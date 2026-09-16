class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    private void helper(int[] nums,List<Integer> level, int i){
        if(i==nums.length){
            ans.add(new ArrayList<>(level));
            return ;
        }
        level.add(nums[i]);
        helper(nums,level,i+1);
        level.remove(level.size()-1);
        helper(nums,level,i+1);

    }
    public List<List<Integer>> subsets(int[] nums) {
        

        helper(nums,new ArrayList<>(),0);

        return ans;
    }
}