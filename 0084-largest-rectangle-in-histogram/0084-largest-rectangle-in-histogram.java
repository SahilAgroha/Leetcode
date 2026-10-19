class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int nsr[]=new int[n];
        Stack<Integer> s=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            nsr[i]=s.isEmpty()?n:s.peek();
            s.push(i);
        }

        int nsl[]=new int[n];
        s=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s.isEmpty() && heights[s.peek()]>=heights[i]){
                s.pop();
            }
            nsl[i]=s.isEmpty()?-1:s.peek();
            s.push(i);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            ans=Math.max(ans,heights[i]*(nsr[i]-nsl[i]-1));
        }
        return ans;
    }
}