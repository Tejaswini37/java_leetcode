class Solution {
    public int helper(int i,int n,int dp[]){
        if(i>n) return 0;
        if(i==n) return 1;
        if(dp[i]!=-1) return dp[i];
        dp[i]=helper(i+1,n,dp)+helper(i+2,n,dp);
        return dp[i];
        
    }
    public int climbStairs(int n) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return helper(0,n,dp);
    }
}
// class Solution {
//     public int helper(int i,int n){
//         if(i==n) return 1;
//         int ans=helper(i+1,n);
//         if(i+2<=n) ans+=helper(i+2,n);
//         return ans;
        // if(i>n) return 0;
        // if(i==n) return 1;
        // return helper(i+1,n)+helper(i+2,n);
//     }
//     public int climbStairs(int n) {
//         return helper(0,n);
//     }
// }