class Solution {
    private int findPar(int x,int[] par){
        if(par[x]==x){
            return x;
        }
        return findPar(par[x],par);
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        int[] par=new int[n+1];
        for(int i=0;i<=n;i++){
            par[i]=i;
        }

        for(int[] edge : edges){
            int par1=findPar(edge[0],par);
            int par2=findPar(edge[1],par);
            if(par1==par2){
                return edge;
            }
            par[par1]=par2;
        }

        return new int[2];
    }
}