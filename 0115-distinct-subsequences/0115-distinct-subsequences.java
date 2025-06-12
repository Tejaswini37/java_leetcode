class Solution {
    public static int helper(int ind1,int ind2,String s,String t,int dp[][]){
        if(ind2<0) return 1;
        if(ind1<0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s.charAt(ind1)==t.charAt(ind2)){
            return dp[ind1][ind2]=helper(ind1-1,ind2-1,s,t,dp)+helper(ind1-1,ind2,s,t,dp);
        }
        else{
            return dp[ind1][ind2]=helper(ind1-1,ind2,s,t,dp);
        }
    }
    public int numDistinct(String s, String t) {
        int n=s.length(),m=t.length();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        // for (int i = 1; i <= m ; i++) {
        //     dp[0][i] = 0;
        // } no need this intially 0
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][m];
    }
}

//  s1=babgbag  s2=bag  ans=5
// class Solution {
//     public static int helper(int ind1,int ind2,String s,String t,int dp[][]){
//         if(ind2<0) return 1;
//         if(ind1<0) return 0;
//         if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
//         if(s.charAt(ind1)==t.charAt(ind2)){
//             return dp[ind1][ind2]=helper(ind1-1,ind2-1,s,t,dp)+helper(ind1-1,ind2,s,t,dp);
//         }
//         else{
//             return dp[ind1][ind2]=helper(ind1-1,ind2,s,t,dp);
//         }
//     }
//     public int numDistinct(String s, String t) {
//         int n=s.length(),m=t.length();
//         int dp[][]=new int[n][m];
//         for(int r[]:dp) Arrays.fill(r,-1);
//         return helper(n-1,m-1,s,t,dp);
//     }
// }

// class Solution {
//     public static int helper(int ind1,int ind2,String s,String t){
//         if(ind2<0) return 1;
//         if(ind1<0) return 0;
//         if(s.charAt(ind1)==t.charAt(ind2)){
//             return helper(ind1-1,ind2-1,s,t)+helper(ind1-1,ind2,s,t);
//         }
//         else{
//             return helper(ind1-1,ind2,s,t);
//         }
//     }
//     public int numDistinct(String s, String t) {
//         int n=s.length(),m=t.length();
//         return helper(n-1,m-1,s,t);
//     }
// }
