class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int capacity = 2;
        int[][][] dp = new int[n + 1][2][capacity + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= capacity; cap++) {
                    if (buy == 0) {
                        dp[i][buy][cap] = Math.max(
                            -prices[i] + dp[i + 1][1][cap],
                            dp[i + 1][0][cap]
                        );
                    } else {
                        dp[i][buy][cap] = Math.max(
                            prices[i] + dp[i + 1][0][cap - 1],
                            dp[i + 1][1][cap]
                        );
                    }
                }
            }
        }

        return dp[0][0][capacity];
    }
}



// class Solution {
//     public int helper(int ind,int bs,int prices[],int n,int cap,int dp[][][]){
//         if(cap==0 || ind==n) return 0;
//         if(dp[ind][bs][cap]!=-1) return dp[ind][bs][cap];
//         if(bs==0){
//             return dp[ind][bs][cap]=Math.max(-prices[ind]+helper(ind+1,1,prices,n,cap,dp),helper(ind+1,0,prices,n,cap,dp));
//         }
//         else{
//             return dp[ind][bs][cap]=Math.max(prices[ind]+helper(ind+1,0,prices,n,cap-1,dp),helper(ind+1,1,prices,n,cap,dp));
//         }
//     }
//     public int maxProfit(int[] prices) {
//         int n=prices.length;
//         int cap=2;
//         int dp[][][]=new int[n][2][cap+1];
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < 2; j++) {
//                 Arrays.fill(dp[i][j], -1);
//             }
//         }
//         return helper(0,0,prices,n,cap,dp);
//     }
// }

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