class Solution {
    public String removeOuterParentheses(String s) {
        int n=s.length();
        int open=0;
        int close=0;
        int start=0;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                open++;
            } else {
                close++;
            }

            if(open==close){
                StringBuilder sb=new StringBuilder();
                for(int j=1;j<2*open-1;j++){
                    sb.append(s.charAt(j+start));
                }
                start=i+1;
                open=close=0;

                ans.append(sb);

            }
        }
        return ans.toString();
    }
}