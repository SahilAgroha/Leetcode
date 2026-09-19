class Solution {
    private boolean isAnagram(int[] sf, int[] pf){
        for(int i=0;i<256;i++){
            if(sf[i]!=pf[i]){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        int sf[]=new int[256];
        int pf[]=new int[256];
        for(int i=0;i<p.length();i++){
            pf[p.charAt(i)]++;
        }

        int low=0;
        int len=0;
        List<Integer> ans=new ArrayList<>();
        for(int high=0;high<s.length();high++){
            sf[s.charAt(high)]++;
            len=high-low+1;
            while(len>p.length()){
                sf[s.charAt(low++)]--;
                len--;
            }

            if(isAnagram(sf,pf)){
                ans.add(low);
            }
        }

        return ans;
    }
}