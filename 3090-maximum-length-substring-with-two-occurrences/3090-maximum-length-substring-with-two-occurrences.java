class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int i,j=0;
        HashMap<Character,Integer> map=new HashMap<>();

        int ans=0;

        for(i=0;i<n;i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>2){
                char ch1=s.charAt(j);
                map.put(ch1,map.get(ch1)-1);
                j++;
            }
            ans=Math.max(ans,i-j+1);
        }

        return ans;

    }
}