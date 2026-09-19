class Solution {
    private int findPar(int[] par, int idx){
        if(par[idx]==idx){
            return par[idx];
        }
        return par[idx]=findPar(par, par[idx]);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] par=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }

        for(int[] e: edges){
            int parA=findPar(par,e[0]-1);
            int parB=findPar(par,e[1]-1);
            if(parA==parB){
                return e;
            }

            par[parB]=parA;
        }

        return new int[]{-1,-1};
    }
}