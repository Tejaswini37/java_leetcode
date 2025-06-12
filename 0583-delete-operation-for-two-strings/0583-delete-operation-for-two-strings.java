class Solution {
    //insert,delete,replace not for this question
    // public int helper(int ind1,int ind2,String s1,String s2){
    //     if(ind1<0 && ind2<0) return 1;
    //     if(ind1<0 || ind2<0) return 0;
    //     if(s1.charAt(ind1)==s2.charAt(ind2)){
    //         return helper(ind1-1,ind2-1,s1,s2);
    //     }
    //     else{
    //         return 1+Math.min(helper(ind1-1,ind2-1,s1,s2),Math.min(helper(ind1-1,ind2,s1,s2),helper(ind1,ind2-1,s1,s2)));
    //     }
    // }
    public int minDistance(String word1, String word2) {
        int n1=word1.length(),n2=word2.length();
        // deletions=n-len(lcs)
        // insertions=m-len(lcs)
        // total=n+m-(2*len(lcs))
        int dp[][]=new int[n1+1][n2+1];
        for(int i=0;i<=n1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<=n2;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return n1+n2-(dp[n1][n2]*2);
        
    }
}