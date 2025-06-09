class Solution {
    public int helper(int i,int j,List<List<Integer>> a,int dp[][]){
        if(i==a.size()-1) return a.get(i).get(j);
        if(dp[i][j]!=-1) return dp[i][j];
        int down=a.get(i).get(j)+helper(i+1,j,a,dp);
        int diagonal=a.get(i).get(j)+helper(i+1,j+1,a,dp);
        return dp[i][j]=Math.min(down,diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int dp[][]=new int[triangle.size()][triangle.size()];
        for(int r[]:dp) Arrays.fill(r,-1);
        return helper(0,0,triangle,dp);
        
    }
}