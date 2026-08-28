class Solution {

    private int findPar(int x, int[] par) {
        if (par[x] == x) {
            return x;
        }

        return par[x] = findPar(par[x], par);
    }

    public int makeConnected(int n, int[][] connections) {

        int[] par = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
        }

        int extraCable = 0;
        int components = n;

        for (int[] connection : connections) {

            int u = connection[0];
            int v = connection[1];

            int par1 = findPar(u, par);
            int par2 = findPar(v, par);

            if (par1 == par2) {
                // This cable is redundant
                extraCable++;
            } else {
                par[par2] = par1;
                components--;
            }
        }

        if (extraCable < components - 1) {
            return -1;
        }

        return components - 1;
    }
}