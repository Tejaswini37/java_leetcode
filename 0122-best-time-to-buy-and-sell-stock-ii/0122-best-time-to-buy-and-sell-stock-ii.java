class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2]; // size n+1 to allow dp[i+1]

        dp[n][0] = dp[n][1] = 0; // base case

        for (int i = n - 1; i >= 0; i--) {
            int price = prices[i];
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(-price + dp[i + 1][1], dp[i + 1][0]);
                } else {
                    dp[i][j] = Math.max(price + dp[i + 1][0], dp[i + 1][1]);
                }
            }
        }
        return dp[0][0];
    }
}


// class Solution {
//     public int helper(int ind,int bs,int prices[],int n,int dp[][]){
//         if(ind==n) return 0;
//         int profit=0;
//         if(dp[ind][bs]!=-1) return dp[ind][bs];
//         if(bs==1){ //buy=1, sell=0
//             profit=Math.max(-prices[ind]+helper(ind+1,0,prices,n,dp),helper(ind+1,1,prices,n,dp));
//         }
//         else{
//             profit=Math.max(prices[ind]+helper(ind+1,1,prices,n,dp),helper(ind+1,0,prices,n,dp));
//         }
      
//         return dp[ind][bs]=profit;
//     }
//     public int maxProfit(int[] prices) {
//         int n=prices.length;
//         int dp[][]=new int[n][2];
//         for(int r[]:dp) Arrays.fill(r,-1);
//         return helper(0,1,prices,prices.length,dp);
//     }
// }

// class Solution {
//     public int helper(int ind,int bs,int prices[],int n){
//         if(ind==n) return 0;
//         int profit=0;
//         if(bs==1){ //buy=1, sell=0
//             profit=Math.max(-prices[ind]+helper(ind+1,0,prices,n),helper(ind+1,1,prices,n));
//         }
//         else{
//             profit=Math.max(prices[ind]+helper(ind+1,1,prices,n),helper(ind+1,0,prices,n));
//         }
//         return profit;
//     }
//     public int maxProfit(int[] prices) {
//         int n=prices.length;
//         return helper(0,1,prices,prices.length);
//     }
// }