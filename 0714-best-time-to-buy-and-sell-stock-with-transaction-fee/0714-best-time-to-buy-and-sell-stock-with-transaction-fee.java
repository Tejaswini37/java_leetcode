class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int dp[][]=new int[n+1][2];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                if(buy==0){
                    dp[i][buy]=Math.max(-prices[i]+dp[i+1][1],dp[i+1][0]);
                }
                else{
                    dp[i][buy]=Math.max(prices[i]+dp[i+1][0]-fee,dp[i+1][1]);
                }
            }
        }
        return dp[0][0];
    }
}