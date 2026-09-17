class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> set=new HashMap<>();
        int sum=0;
        set.put(sum,1);
        int ans=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(set.containsKey(sum-k)){
                ans+=set.get(sum-k);
            }
            set.put(sum,set.getOrDefault(sum,0)+1);
        }

        return ans;
    }
}