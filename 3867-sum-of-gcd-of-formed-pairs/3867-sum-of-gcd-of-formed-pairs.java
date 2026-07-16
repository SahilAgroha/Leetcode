class Solution {
    public long gcdSum(int[] nums) {
        int max=nums[0];
        int n=nums.length;

        int prefixGcd[]=new int[n];
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            prefixGcd[i]=gcd(max,nums[i]);
        }

        Arrays.sort(prefixGcd);

        long ans=0;

        for(int i=0;i<n/2;i++){
            ans+=gcd(prefixGcd[n-i-1],prefixGcd[i]);
        }
        return ans;

        
    }

    private int gcd(int a, int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return Math.abs(a);
    }
}