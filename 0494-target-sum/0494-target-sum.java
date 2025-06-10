class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum<target) return 0;
        if((sum-target)%2!=0) return 0;
        target=(sum-target)/2;
        int dp[][]=new int[n][target+1];
        if(nums[0]==0) dp[0][0]=2; // pick and not pick
        else dp[0][0]=1;//not pick
        if(nums[0]!=0 && nums[0]<=target) dp[0][nums[0]]=1;
        for(int i=1;i<n;i++){
            for(int tar=0;tar<=target;tar++){
                int notpick=dp[i-1][tar];
                int pick=0;
                if(nums[i]<=tar) pick=dp[i-1][tar-nums[i]];
                dp[i][tar]=pick+notpick;
            }
        }
        return dp[n-1][target];
    }
}

// class Solution {
//     public static int sumways(int a[],int dp[][],int i,int k){
//         if(i==0){
//             if(k==0 && a[i]==0) return 2;
//             if(a[i]==k || k==0)  return 1;
//             return 0;
//         }
       
//         if(dp[i][k]!=-1) return dp[i][k];
//         int notpick=sumways(a,dp,i-1,k);
//         int pick=0;
//         if(a[i]<=k)
//         pick=sumways(a,dp,i-1,k-a[i]);
//         return dp[i][k]=notpick+pick;
//     }
//     public int findTargetSumWays(int[] nums, int target) {
//         int n=nums.length;
//         int sum=0;
//         for(int i=0;i<n;i++){
//             sum+=nums[i];
//         }
//         if(sum<target) return 0;
//         if((sum-target)%2!=0) return 0;
//         target=(sum-target)/2;
//         int dp[][]=new int[n][target+1];
//         for(int r[]:dp){
//             Arrays.fill(r,-1);
//         }
//         int res=sumways(nums,dp,n-1,target);
//         return res;
//     }
// }