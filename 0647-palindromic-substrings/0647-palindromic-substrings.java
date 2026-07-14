class Solution {
    private int expand(String s, int i, int j){
        int count=0;

        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            count++;
            i--;
            j++;
        }
        return count;
    }
    public int countSubstrings(String s) {
        int ans=0;

        for(int i=0;i<s.length();i++){
            ans+=expand(s,i,i);
            ans+=expand(s,i,i+1);
        }
        return ans;
    }
}