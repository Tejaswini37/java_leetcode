class Solution {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int dp[][]=new int[n][amount+1];
        for(int k=0;k<=amount;k++){
            if(k%coins[0]==0) dp[0][k]=1;
            else dp[0][k]=0;
        }
        for(int i=1;i<n;i++){
            for(int k=0;k<=amount;k++){
                int notpick=dp[i-1][k];
                int pick=0;
                if(coins[i]<=k) pick=dp[i][k-coins[i]];
                dp[i][k]=pick+notpick;
            }
        }
        return dp[n-1][amount];
        
    }
}

// class Solution {
//     public static int ways(int a[],int dp[][],int i,int k){
//         if(i==0){
//             if(k%a[0]==0) return 1; //k=4, a[0]=2 one way
//             else return 0;
//         }
//         if(dp[i][k]!=-1) return dp[i][k];
//         int notpick=ways(a,dp,i-1,k);
//         int pick=0;
//         if(a[i]<=k) pick=ways(a,dp,i,k-a[i]);
//         return dp[i][k]=pick+notpick;
//     }
//     public int change(int amount, int[] coins) {
//         int n=coins.length;
//         int dp[][]=new int[n][amount+1];
//         for(int r[]: dp){
//             Arrays.fill(r,-1);
//         }  
//         int res=ways(coins,dp,n-1,amount);
//         return res; 
//     }
// }