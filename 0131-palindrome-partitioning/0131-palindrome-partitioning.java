class Solution {
    List<List<String>> ans;
    private boolean isPalindrom(String s, int start, int end){
        while(start<end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
    private void helper(String s , int idx, List<String> path){
        if(idx==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=idx+1;i<=s.length();i++){
            if(isPalindrom(s,idx,i-1)){
                path.add(s.substring(idx,i));
                helper(s,i,path);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        helper(s,0, new ArrayList<>());
        return ans;
    }
}