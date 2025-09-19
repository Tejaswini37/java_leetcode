// class Solution {
//     public int minCostClimbingStairs(int[] cost) {
        
//     }
// }
class Solution {
    public int dfs(int cost[],int dp[],int i){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=cost[i]+Math.min(dfs(cost,dp,i+1),dfs(cost,dp,i+2));
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(dfs(cost,dp,0),dfs(cost,dp,1));
    }
}
// class Solution {
//     public int dfs(int cost[],int i){
//         if(i>=cost.length) return 0;
//         return cost[i]+Math.min(dfs(cost,i+1),dfs(cost,i+2));
//     }
//     public int minCostClimbingStairs(int[] cost) {
//         return Math.min(dfs(cost,0),dfs(cost,1));
//     }
// }