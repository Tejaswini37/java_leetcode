class Solution {
    public int helper(int i,int j,int a[][],int dp[][]){
        if(i<0 || j<0) return 0; 
        if(a[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int left=helper(i,j-1,a,dp);
        int up=helper(i-1,j,a,dp);
        return dp[i][j]=left+up;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][]=new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int r[]:dp) Arrays.fill(r,-1);
        return helper(obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid,dp);
    }
}