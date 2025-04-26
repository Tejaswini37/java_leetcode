class Solution {
    public static int fewest(int[] coins,int dp[][],int i,int k){
        if(i==0){
            if(k%coins[0]==0) return k/coins[0];
            else return (int) Math.pow(10,9);
        }
        if(dp[i][k]!=-1) return dp[i][k];
        int nottake=fewest(coins,dp,i-1,k);
        int take=(int) Math.pow(10,9);;
        if(coins[i]<=k) take=1+fewest(coins,dp,i,k-coins[i]);
        return dp[i][k]=Math.min(take,nottake);

    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        int res=fewest(coins,dp,n-1,amount);
        return (res<(int)Math.pow(10,9))?res:-1;
    }
}