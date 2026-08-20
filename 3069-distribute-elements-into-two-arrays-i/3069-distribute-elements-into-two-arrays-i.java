class Solution {
    public int[] resultArray(int[] nums) {
        int n=nums.length;
        if(n<3){
            return nums;
        }
        List<Integer> arr2=new ArrayList<>();
        arr2.add(nums[1]);
        int j=0;
        for(int i=2;i<n;i++){
            if(nums[j]>arr2.get(arr2.size()-1)){
                nums[++j]=nums[i];
            } else {
                arr2.add(nums[i]);
            }
        }
        int k=0;
        for(int i=j+1;i<n;i++){
            nums[i]=arr2.get(k++);
        }

        return nums;
    }
}