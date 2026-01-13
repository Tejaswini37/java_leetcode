class Solution {
    int n;
    int stones[];
    int memo[];
    public String stoneGameIII(int[] stoneValue) {
        n=stoneValue.length;
        stones=stoneValue;
        memo=new int[n];
        Arrays.fill(memo,-1);
        int diff=dfs(0);
        if(diff<0) return "Bob";
        if(diff>0) return "Alice";
        return "Tie";
    }
    public int dfs(int i){
        if(i>=n) return 0;
        if(memo[i]!=-1) return memo[i];
        int best=Integer.MIN_VALUE;
        int take=0;
        for(int k=0;k<3 && i+k<n;k++){
            take+=stones[i+k];
            best=Math.max(best,take-dfs(i+k+1));
        }
        return memo[i]=best;
    }
}

// class Solution {
//     public int integerBreak(int n) {

//         int[] dp = new int[n + 1];
//         dp[1] = 1;

//         for (int i = 2; i <= n; i++) {
//             for (int j = 1; j < i; j++) {
//                 dp[i] = Math.max(dp[i],
//                         Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
//             }
//         }

//         return dp[n];
//     }
// }
