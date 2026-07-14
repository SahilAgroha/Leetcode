class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map=new HashMap<>();
        int left=0, res=0, max=0;

        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            map.put(ch,map.getOrDefault(ch,0)+1);
            max=Math.max(max,map.get(ch));

            while((right-left+1)-max>k){
                char last=s.charAt(left);
                map.put(last, map.get(last)-1);
                left++;
            }

            res=Math.max(res,right-left+1);
        }
        return res;
    }
}