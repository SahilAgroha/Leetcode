class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet<>();
        for(int n:nums){
            set.add(n);
        }int i=1;
        while(true){
            if(!set.contains(k*i)){
                break;
            }
            i++;
        }
        return k*i;
    }
}