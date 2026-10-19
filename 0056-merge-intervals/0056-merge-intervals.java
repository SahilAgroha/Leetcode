class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> result=new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<intervals.length;i++){
            if(end>=intervals[i][0]){
                end=Math.max(end,intervals[i][1]);
            } else {
                result.add(new int[]{start,end});
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        result.add(new int[]{start,end});

        int[][] ans=new int[result.size()][2];
        for(int i=0;i<result.size();i++){
            ans[i][0]=result.get(i)[0];
            ans[i][1]=result.get(i)[1];
        }

        return ans;
    }
}