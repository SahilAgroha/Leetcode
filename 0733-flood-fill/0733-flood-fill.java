class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        helper(image,sr,sc,image[sr][sc],color);
        return image;
    }
    private void helper(int[][] image, int sr, int sc,int orgCol, int color){
        if(sr<0 || sr>=image.length || sc<0 || sc>=image[0].length || orgCol==color || image[sr][sc]!=orgCol){
            return;
        }
        if(image[sr][sc]==orgCol){
            image[sr][sc]=color;
        }
        helper(image,sr,sc-1,orgCol,color);
        helper(image,sr,sc+1,orgCol,color);
        helper(image,sr-1,sc,orgCol,color);
        helper(image,sr+1,sc,orgCol,color);
    }
}