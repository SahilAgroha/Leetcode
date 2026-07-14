class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        HashSet<Character> set=new HashSet<>();
        int j=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            while(set.contains(ch)){
                char last=s.charAt(j);
                set.remove(last);
                j++;
            }
            set.add(ch);
            max=Math.max(max,set.size());
        }

        return max;
    }
}