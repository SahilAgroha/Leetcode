class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n=s.length();
        List<Integer> count=new ArrayList<>();
        int zeros=0;
        int totalZero=0;

        for(int i=0;i<n;i++){
            int num=s.charAt(i)-'0';
            if(num==0){
                zeros++;
                totalZero++;
            } else if(zeros!=0) {
                count.add(zeros);
                zeros=0;
            }
        }
        if(zeros!=0){
            count.add(zeros);
        }
        int ans=0;
        for(int i=1;i<count.size();i++){
            ans=Math.max(ans, count.get(i-1)+count.get(i));
        }

        return n-totalZero+ans;

    }
}