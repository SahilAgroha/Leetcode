class Solution {
    public int minimumPushes(String word) {
        int[] count=new int[26];
        int n=word.length();
        for(int i=0;i<n;i++){
            count[word.charAt(i)-'a']++;
        }

        Arrays.sort(count);
        int ans=0;
        int rank=0;
        for(int i=25;i>=0;i--){
            if(count[i]==0){
                break;
            }
            ans+=count[i]*(rank/8+1);
            rank++;
        }

        return ans;

    }
}