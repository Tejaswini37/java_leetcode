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
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int cap=k;
        int dp[][][]=new int[n][2][cap+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return helper(0,0,prices,n,cap,dp);
    }
    
    
}