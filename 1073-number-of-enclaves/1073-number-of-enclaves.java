class Solution {
    public void dfs(int r,int c,int grid[][], int m,int n){
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]==0) return;
        grid[r][c]=0;
        dfs(r+1,c,grid,m,n);
        dfs(r-1,c,grid,m,n);
        dfs(r,c+1,grid,m,n);
        dfs(r,c-1,grid,m,n);
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length, n=grid[0].length;
        for(int j=0;j<n;j++){ // first and last row
            if(grid[0][j]==1) dfs(0,j,grid,m,n);
            if(grid[m-1][j]==1) dfs(m-1,j,grid,m,n);
        }
//'2️⃣ Flood-fil first and last columns
        for(int i=0;i<m;i++){
            if(grid[i][0]==1) dfs(i,0,grid,m,n);
            if(grid[i][n-1]==1) dfs(i,n-1,grid,m,n);
        }
        // count remaining
        
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) c++;
            }
        }
        return c;
    }
}