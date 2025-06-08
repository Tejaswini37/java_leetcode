class Solution {
    public int helper(int i,int j ,int m,int n,int dp[][]){
        if(i==m-1 && j==n-1) return 1;
        if(i==m || j==n) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int down=helper(i+1,j,m,n,dp);
        int right=helper(i,j+1,m,n,dp);
        return dp[i][j]=down+right;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int r[]:dp) Arrays.fill(r,-1);
        return helper(0,0,m,n,dp);

    }
}

// class Solution {
//     public int helper(int i,int j ,int m,int n){
//         if(i==m-1 && j==n-1) return 1;
//         if(i==m || j==n) return 0;
//         int down=helper(i+1,j,m,n);
//         int right=helper(i,j+1,m,n);
//         return down+right;
//     }
//     public int uniquePaths(int m, int n) {
//         return helper(0,0,m,n);
//     }
// }