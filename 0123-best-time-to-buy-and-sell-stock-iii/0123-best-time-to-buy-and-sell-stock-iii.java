class Solution {
    public int helper(int ind,int bs,int prices[],int n,int cap,int dp[][][]){
        if(cap==0 || ind==n) return 0;
        if(dp[ind][bs][cap]!=-1) return dp[ind][bs][cap];
        if(bs==0){
            return dp[ind][bs][cap]=Math.max(-prices[ind]+helper(ind+1,1,prices,n,cap,dp),helper(ind+1,0,prices,n,cap,dp));
        }
        else{
            return dp[ind][bs][cap]=Math.max(prices[ind]+helper(ind+1,0,prices,n,cap-1,dp),helper(ind+1,1,prices,n,cap,dp));
        }
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int cap=2;
        int dp[][][]=new int[n][2][cap+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0,0,prices,n,cap,dp);
    }
}

// class Solution {
//     public int helper(int ind,int bs,int prices[],int n,int cap){
//         if(cap==0 || ind==n) return 0;
//         if(bs==0){
//             return Math.max(-prices[ind]+helper(ind+1,1,prices,n,cap),helper(ind+1,0,prices,n,cap));
//         }
//         else{
//             return Math.max(prices[ind]+helper(ind+1,0,prices,n,cap-1),helper(ind+1,1,prices,n,cap));
//         }
//     }
//     public int maxProfit(int[] prices) {
//         int n=prices.length;
//         int cap=2;
//         return helper(0,0,prices,n,cap);
//     }
// }