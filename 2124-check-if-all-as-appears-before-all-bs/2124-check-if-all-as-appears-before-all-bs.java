class Solution {
    public boolean checkString(String s) {
        boolean a=false;
        boolean b=false;
        for(int i=0;i<s.length();i++){
            char ch =s.charAt(i);
            if(ch=='a' && b){
                return false;
            } else if(ch=='a'){
                a=true;
            } else {
                b=true;
            }
        }
        return true;
    }
}