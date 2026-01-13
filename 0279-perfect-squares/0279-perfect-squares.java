class Solution {
    public int numSquares(int n) {
        int memo[]=new int[n+1];
        Arrays.fill(memo,-1);
        return dfs(n,memo);
    }
    public int dfs(int n,int memo[]){
        if(n==0) return 0;
        if(n<0) return Integer.MAX_VALUE;
        if(memo[n]!=-1) return memo[n];
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int sq=i*i;
            int res=dfs(n-sq,memo);
            if(res!=Integer.MAX_VALUE){
                min=Math.min(min,1+res);
            }
        }
        return memo[n]=min;
    }
}

// class Solution {
//     public int numSquares(int n) {

//         int[] dp = new int[n + 1];

//         // Initialize with max value
//         Arrays.fill(dp, Integer.MAX_VALUE);

//         dp[0] = 0;

//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j * j <= i; j++) {
//                 int sq = j * j;
//                 dp[i] = Math.min(dp[i], 1 + dp[i - sq]);
//             }
//         }

//         return dp[n];
//     }
// }
