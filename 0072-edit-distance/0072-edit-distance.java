class Solution {
    public static int helper(int ind1,int ind2,String s1,String s2,int dp[][]){
        if(ind1<0) return ind2+1; //insertions in second array
        if(ind2<0) return ind1+1; //deletions in s1 to make equal to s2
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2)) return dp[ind1][ind2]=helper(ind1-1,ind2-1,s1,s2,dp);
        else{
            return dp[ind1][ind2]=1+Math.min(helper(ind1-1,ind2-1,s1,s2,dp),Math.min(helper(ind1,ind2-1,s1,s2,dp),helper(ind1-1,ind2,s1,s2,dp)));
        }
    }
    public int minDistance(String word1, String word2) {
        int n=word1.length(),m=word2.length();
        int dp[][]=new int[n][m];
        for(int r[]:dp) Arrays.fill(r,-1);
        return helper(n-1,m-1,word1,word2,dp);
    }
}

// class Solution {
//     public static int helper(int ind1,int ind2,String s1,String s2){
//         if(ind1<0) return ind2+1; //insertions in second array
//         if(ind2<0) return ind1+1; //deletions in s1 to make equal to s2
//         if(s1.charAt(ind1)==s2.charAt(ind2)) return helper(ind1-1,ind2-1,s1,s2);
//         else{
//             return 1+Math.min(helper(ind1-1,ind2-1,s1,s2),Math.min(helper(ind1,ind2-1,s1,s2),helper(ind1-1,ind2,s1,s2)));
//         }
//     }
//     public int minDistance(String word1, String word2) {
//         int n=word1.length(),m=word2.length();
//         return helper(n-1,m-1,word1,word2);
//     }
// }