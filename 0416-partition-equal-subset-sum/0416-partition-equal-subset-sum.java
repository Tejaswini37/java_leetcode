class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        int k=sum/2;
        boolean dp[][]=new boolean[n][k+1];
        for(int i=0;i<n;i++) dp[i][0]=true;
        if(nums[0]<=k) dp[0][nums[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=k;j++){ //j==target
                boolean nottake=dp[i-1][j];
                boolean take=false;
                if(nums[i]<=j) take=dp[i-1][j-nums[i]];
                dp[i][j]=take | nottake;
            }
        }
        return dp[n-1][k];
    }
}

// class Solution {
//     public static boolean subset(int a[],int dp[][],int i,int k){
//         if(k==0) return true;
//         if(i==0) return a[0]==k;
//         if(dp[i][k]!=-1) return (dp[i][k]==1)?true:false;
//         boolean nottake=subset(a,dp,i-1,k);
//         boolean take=false;
//         if(a[i]<=k) take=subset(a,dp,i-1,k-a[i]);
//         dp[i][k]=(take || nottake)?1:0;
//         return take || nottake;
//     }
    
//     public boolean canPartition(int[] nums) {
//         int sum=0;
//         int n=nums.length;
//         for(int i=0;i<n;i++){
//             sum+=nums[i];
//         }
//         if(sum%2==1) return false;
//         int k=sum/2;
//         int dp[][]=new int[n][k+1];
//         for(int row[] : dp) Arrays.fill(row,-1);
//         return subset(nums,dp,n-1,k);
//     }
// }