class Solution {
    public static int ways(int a[],int dp[][],int i,int k){
        if(i==0){
            if(k%a[0]==0) return 1;
            else return 0;
        }
        if(dp[i][k]!=-1) return dp[i][k];
        int notpick=ways(a,dp,i-1,k);
        int pick=0;
        if(a[i]<=k) pick=ways(a,dp,i,k-a[i]);
        return dp[i][k]=pick+notpick;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int r[]: dp){
            Arrays.fill(r,-1);
        }  
        int res=ways(coins,dp,n-1,amount);
        return res; 
    }
}