class Solution {
    public int longestPalindromeSubseq(String s) {
        String s2=new StringBuilder(s).reverse().toString();
        int n=s.length();
        int dp[][]=new int[n+1][n+1];
        for(int r[]:dp){
            Arrays.fill(r,-1);
        }
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int i=0;i<=n;i++) dp[0][i]=0;
        for(int i1=1;i1<=n;i1++){
            for(int i2=1;i2<=n;i2++){
                if(s.charAt(i1-1)==s2.charAt(i2-1))
                dp[i1][i2]=1+dp[i1-1][i2-1];
                else
                dp[i1][i2]=Math.max(dp[i1-1][i2],dp[i1][i2-1]);
            }
        }
        return dp[n][n];
    }
}