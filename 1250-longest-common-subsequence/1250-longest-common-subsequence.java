class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()+1][text2.length()+1];
        int n1=text1.length(),n2=text2.length();
        // index -1=0(take) n-1->n do take dp[n1+1][n2+1]
        for(int i=0;i<=n1;i++) dp[i][0]=0;
        for(int i=0;i<=n2;i++) dp[0][i]=0;
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n1][n2];
    }
}

// class Solution {
//     public int lcs(int ind1,int ind2,String text1, String text2,int dp[][]){
//         if(ind1<0 || ind2<0) return 0;
//         if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
//         if(text1.charAt(ind1)==text2.charAt(ind2)){
//             return dp[ind1][ind2]=1+lcs(ind1-1,ind2-1,text1,text2,dp);
//         }
//         return dp[ind1][ind2]=Math.max(lcs(ind1-1,ind2,text1,text2,dp),lcs(ind1,ind2-1,text1,text2,dp));
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         int dp[][]=new int[text1.length()][text2.length()];
//         for(int r[]: dp) Arrays.fill(r,-1);
//         return lcs(text1.length()-1,text2.length()-1,text1,text2,dp);
//     }
// }

// class Solution {
//     public int lcs(int ind1,int ind2,String text1, String text2){
//         if(ind1<0 || ind2<0) return 0;
//         if(text1.charAt(ind1)==text2.charAt(ind2)){
//             return 1+lcs(ind1-1,ind2-1,text1,text2);
//         }
//         return Math.max(lcs(ind1-1,ind2,text1,text2),lcs(ind1,ind2-1,text1,text2));
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         return lcs(text1.length()-1,text2.length()-1,text1,text2);
//     }
// }