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
        int dp[][]=new int[n][m];
        for(int r[]:dp) Arrays.fill(r,-1);
        return helper(n-1,m-1,s,t,dp);
    }
}

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
