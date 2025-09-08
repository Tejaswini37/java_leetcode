class Solution {
    public void dfs(char[][] grid,int m,int n,boolean[][] vis,int r,int c){
        vis[r][c]=true;
        int dirs[][]={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<4;i++){
            int nr=r+dirs[i][0], nc=c+dirs[i][1];
            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]=='1' && vis[nr][nc]==false){
                dfs(grid,m,n,vis,nr,nc);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m=grid.length,n=grid[0].length;
        boolean[][] vis=new boolean[m][n];
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    c++;
                    dfs(grid,m,n,vis,i,j);
                }
            }
        }
        return c;
    }
}