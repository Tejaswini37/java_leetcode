class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int dp[][]=new int[n][m];
        for(int j=0;j<m;j++) dp[0][j]=matrix[0][j];
        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                int up=dp[i-1][j];
                int ld=j>0?dp[i-1][j-1]:Integer.MAX_VALUE;
                int rd=j<m-1?dp[i-1][j+1]:Integer.MAX_VALUE;
                dp[i][j]=matrix[i][j]+Math.min(up,Math.min(ld,rd));
            }
        }
        int mini=Integer.MAX_VALUE;
        for(int j=0;j<m;j++){
            mini=Math.min(mini,dp[n-1][j]);
        }
        return mini;
    }
}


// time limited exceeded for answer
// class Solution {
//     public int helper(int i,int j,int m,int matrix[][],int dp[][]){
        
//         if(i==0) return matrix[0][j];
//         if(dp[i][j]!=-1) return dp[i][j];
//         int up=helper(i-1,j,m,matrix,dp);
//         int ld=Integer.MAX_VALUE;
//         if(j>0)
//         ld=helper(i-1,j-1,m,matrix,dp);
//         int rd=Integer.MAX_VALUE;
//         if(j+1<m)
//         rd=helper(i-1,j+1,m,matrix,dp);
//         return dp[i][j]=matrix[i][j]+Math.min(up,Math.min(ld,rd));
//     }
//     public int minFallingPathSum(int[][] matrix) {
//         int mini=Integer.MAX_VALUE;
//         int n=matrix.length,m=matrix[0].length;
//         int dp[][]=new int[n][m];
//         for(int r[]:dp) Arrays.fill(r,-1);
//         for(int j=0;j<m;j++){
//             mini=Math.min(mini,helper(n-1,j,m,matrix,dp));
//         }
//         return mini;
//     }
// }