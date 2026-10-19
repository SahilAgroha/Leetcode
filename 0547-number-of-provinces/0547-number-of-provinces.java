class Solution {
    private int findPar(int[] par, int idx){
        if(par[idx]==idx){
            return idx;
        }

        return par[idx]=findPar(par,par[idx]);
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int[] par=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
        int count=n;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    int par1=findPar(par,i);
                    int par2=findPar(par,j);
                    if(par1!=par2){
                        par[par2]=par1;
                        count--;
                    }
                }
            }
        }

        return count;
    }
}