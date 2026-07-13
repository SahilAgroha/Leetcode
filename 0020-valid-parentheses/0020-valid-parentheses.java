class Solution {
    public boolean isValid(String str) {
        if(str.isEmpty()){
            return true;
        }

        int n=str.length();
        Stack<Character> s = new Stack<>();
        for(int i=0;i<n;i++){
            char ch=str.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                s.add(ch);
            } else{
                if(s.isEmpty()){
                    return false;
                }
                if((ch==')' && s.peek()=='(') || (ch=='}' && s.peek()=='{') || (ch==']' && s.peek()=='[') ){
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }
}