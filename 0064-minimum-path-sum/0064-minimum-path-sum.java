class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][]=new int[grid.length][grid[0].length];
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j]=grid[0][0];
                else{
                    int up = Integer.MAX_VALUE;
                    int left = Integer.MAX_VALUE;

                    // int up=(int) Math.pow(10,9);
                    if(i>0) up=dp[i-1][j];
                    // int left=(int) Math.pow(10,9);
                    if(j>0) left=dp[i][j-1];
                    dp[i][j]=grid[i][j]+Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }
}

// class Solution {
//     public int helper(int i,int j,int grid[][],int dp[][]){
//         if(i<0 || j<0) return (int) Math.pow(10,9);
//         if(i==0 && j==0) return grid[0][0];
//         if(dp[i][j]!=-1) return dp[i][j];
//         int up=helper(i-1,j,grid,dp);
//         int left=helper(i,j-1,grid,dp);
//         return dp[i][j]=grid[i][j]+Math.min(up,left);
//     }
//     public int minPathSum(int[][] grid) {
//         int dp[][]=new int[grid.length][grid[0].length];
//         for(int r[]:dp) Arrays.fill(r,-1);
//         return helper(grid.length-1,grid[0].length-1,grid,dp);
//     }
// }