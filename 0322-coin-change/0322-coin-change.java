class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int amt=0;amt<=amount;amt++){
            if(amt%coins[0]==0) dp[0][amt]=amt/coins[0];
            else dp[0][amt]=Integer.MAX_VALUE;
        }
        for(int i=1;i<n;i++){
            for(int tar=0;tar<=amount;tar++){
                int nottake=0+dp[i-1][tar];
                int take=Integer.MAX_VALUE;
                if(coins[i]<=tar && dp[i][tar-coins[i]]!=Integer.MAX_VALUE) take=1+dp[i][tar-coins[i]];
                dp[i][tar]=Math.min(take,nottake);
            }
        }
        return dp[n-1][amount]!=Integer.MAX_VALUE?dp[n-1][amount]:-1;
    }
}

// class Solution {
//     public static int fewest(int[] coins,int dp[][],int i,int k){
//         if(i==0){
//             if(k%coins[0]==0) return k/coins[0];
//             else return (int) Math.pow(10,9);
//         }
//         if(dp[i][k]!=-1) return dp[i][k];
//         int nottake=fewest(coins,dp,i-1,k);
//         int take=(int) Math.pow(10,9);;
//         if(coins[i]<=k) take=1+fewest(coins,dp,i,k-coins[i]);
//         return dp[i][k]=Math.min(take,nottake);

//     }
//     public int coinChange(int[] coins, int amount) {
//         int n=coins.length;
//         int dp[][]=new int[n][amount+1];
//         for(int i=0;i<n;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         int res=fewest(coins,dp,n-1,amount);
//         return (res<(int)Math.pow(10,9))?res:-1;
//     }
// }