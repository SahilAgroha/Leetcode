class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> s=new Stack<>();
        int n=temp.length;
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && temp[i]>=temp[s.peek()]){
                s.pop();
            }
            if(!s.isEmpty()){
                int j=s.peek();
                ans[i]=j-i;
            } else {
                ans[i]=0;
            }
            
            s.push(i);
        }

        return ans;
    }
}