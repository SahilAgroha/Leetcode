class Solution {
    public int findGCD(int[] arr) {
        int min=arr[0];
        int max=arr[0];

        for(int i=1;i<arr.length;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }

        while(min!=0){
            int temp=min;
            min=max%min;
            max=temp;
        }
        return max;
    }
}