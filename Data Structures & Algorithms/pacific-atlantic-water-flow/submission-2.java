class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res=new ArrayList<>();
        if(heights==null||heights.length==0){
            return res;
        }
        int rows=heights.length;
        int cols=heights[0].length;
        boolean[][] pac=new boolean[rows][cols];
        boolean[][] alt=new boolean[rows][cols];

        for(int c=0;c<cols;c++){
            dfs(heights,pac,0,c,heights[0][c]);
            dfs(heights,alt,rows-1,c,heights[rows-1][c]);
        }
        for(int r=0;r<rows;r++){
            dfs(heights,pac,r, 0,heights[r][0]);
            dfs(heights,alt,r, cols - 1,heights[r][cols-1]);
        }
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(pac[r][c]&&alt[r][c]){
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;

    }
    private void dfs(int[][] h,boolean[][] vis , int i ,int j,int prev ){
        if(i<0||i>=h.length||j<0||j>=h[0].length){
            return;
        }
        if(vis[i][j]){
            return;
        }
        if(h[i][j]<prev){
            return;
        }
        vis[i][j]=true;
        dfs(h,vis,i+1,j,h[i][j]);
        dfs(h,vis,i-1,j,h[i][j]);
        dfs(h,vis,i,j+1,h[i][j]);
        dfs(h,vis,i,j-1,h[i][j]);
    }
}
