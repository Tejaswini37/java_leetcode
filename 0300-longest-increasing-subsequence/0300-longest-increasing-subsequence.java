class Solution {
    public int lcs(int ind,int previ,int nums[],int n,int dp[][]){
        if(ind==n) return 0;
        if(dp[ind][previ+1]!=-1) return dp[ind][previ+1];
        int nottake=lcs(ind+1,previ,nums,n,dp);
        int take=0;
        if(previ==-1 || nums[ind]>nums[previ]){
            take=1+lcs(ind+1,ind,nums,n,dp);
        }
        return dp[ind][previ+1]=Math.max(nottake,take);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n];
        for(int r[]:dp) Arrays.fill(r,-1);
        return lcs(0,-1,nums,n,dp);
    }
}

// class Solution {
//     public int lcs(int ind,int previ,int nums[],int n){
//         if(ind==n) return 0;
//         int nottake=lcs(ind+1,previ,nums,n);
//         int take=0;
//         if(previ==-1 || nums[ind]>nums[previ]){
//             take=1+lcs(ind+1,ind,nums,n);
//         }
//         return Math.max(nottake,take);
//     }
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         return lcs(0,-1,nums,n);
//     }
// }