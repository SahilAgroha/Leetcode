class Solution {
    private void helper(int[][] image, int sr, int sc, int color, int startColor){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || image[sr][sc]!=startColor){
            return ;
        }

        image[sr][sc]=color;
        int dx[]={1,0,-1,0};
        int dy[]={0,1,0,-1};

        for(int i=0;i<4;i++){
            int nr=sr+dx[i];
            int nc=sc+dy[i];
            helper(image,nr,nc,color,startColor);
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int startColor = image[sr][sc];

        if (startColor == color) {
            return image;
        }

        helper(image,sr,sc,color,startColor);
        return image;
    }
}