class Solution {
    private int findPar(int x, int[] par){
        if(par[x]==x){
            return x;
        }
        return par[x]=findPar(par[x],par);
    }
    public boolean equationsPossible(String[] equations) {
        int par[]=new int[26];
        for(int i=0;i<26;i++){
            par[i]=i;
        }

        for(String eq:equations){
            if(eq.charAt(1)=='='){
                int a=eq.charAt(0)-'a';
                int b=eq.charAt(3)-'a';
                int parA=findPar(a,par);
                int parB=findPar(b,par);

                if(parA!=parB){
                    par[parB]=parA;
                }
            }
        }

        for(String eq:equations){
            if(eq.charAt(1)=='!'){
                int a=eq.charAt(0)-'a';
                int b=eq.charAt(3)-'a';
                int parA=findPar(a,par);
                int parB=findPar(b,par);
                if(parA==parB){
                    return false;
                }
            }
        }

        return true;
    }
}