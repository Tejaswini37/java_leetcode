class Solution {
    
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n];
        int maxi=1;
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[prev]<nums[i])
                dp[i]=Math.max(dp[i],1+dp[prev]);
            }
            maxi=Math.max(dp[i],maxi);
        }
        return maxi;
    }
}

// tabulation
// class Solution {
    
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         int dp[][]=new int[n+1][n+1];
//         for(int i=n-1;i>=0;i--){
//             for(int prev=i-1;prev>=-1;prev--){
//                 int len=dp[i+1][prev+1];
//                 if(prev==-1 || nums[i]>nums[prev]){
//                     len=Math.max(len,1+dp[i+1][i+1]);
//                 }
//                 dp[i][prev+1]=len;
//             }
//         }
//         return dp[0][0];
//         // we are storing prev=prev+1 beacause of -1 
//         //changing the co ordinates 
//     }
// }

// class Solution {
//     public int lcs(int ind,int previ,int nums[],int n,int dp[][]){
//         if(ind==n) return 0;
//         if(dp[ind][previ+1]!=-1) return dp[ind][previ+1];
//         int nottake=lcs(ind+1,previ,nums,n,dp);
//         int take=0;
//         if(previ==-1 || nums[ind]>nums[previ]){
//             take=1+lcs(ind+1,ind,nums,n,dp);
//         }
//         return dp[ind][previ+1]=Math.max(nottake,take);
//     }
//     public int lengthOfLIS(int[] nums) {
//         int n=nums.length;
//         int dp[][]=new int[n][n];
//         for(int r[]:dp) Arrays.fill(r,-1);
//         return lcs(0,-1,nums,n,dp);
//     }
// }

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