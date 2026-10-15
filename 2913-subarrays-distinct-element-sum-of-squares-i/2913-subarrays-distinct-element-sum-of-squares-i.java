class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans=0;
        HashSet<Integer> s;
        int n=nums.size();
        for(int i=0;i<n;i++){
            s=new HashSet<>();
            for(int j=i;j<n;j++){
                s.add(nums.get(j));
                int x=s.size();
                ans+=x*x;
            }
            
        }
        return ans;
    }
}