class Solution {
    public int helper(int ind,int bs,int prices[],int n,int dp[][]){
        if(ind==n) return 0;
        int profit=0;
        if(dp[ind][bs]!=-1) return dp[ind][bs];
        if(bs==1){ //buy=1, sell=0
            profit=Math.max(-prices[ind]+helper(ind+1,0,prices,n,dp),helper(ind+1,1,prices,n,dp));
        }
        else{
            profit=Math.max(prices[ind]+helper(ind+1,1,prices,n,dp),helper(ind+1,0,prices,n,dp));
        }
      
        return dp[ind][bs]=profit;
    }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int r[]:dp) Arrays.fill(r,-1);
        return helper(0,1,prices,prices.length,dp);
    }
}

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