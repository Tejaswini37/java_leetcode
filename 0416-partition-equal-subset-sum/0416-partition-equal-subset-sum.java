class Solution {
    public static boolean subset(int a[],int dp[][],int i,int k){
        if(k==0) return true;
        if(i==0) return a[0]==k;
        if(dp[i][k]!=-1) return (dp[i][k]==1)?true:false;
        boolean nottake=subset(a,dp,i-1,k);
        boolean take=false;
        if(a[i]<=k) take=subset(a,dp,i-1,k-a[i]);
        dp[i][k]=(take || nottake)?1:0;
        return take || nottake;
    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        int k=sum/2;
        int dp[][]=new int[n][k+1];
        for(int row[] : dp) Arrays.fill(row,-1);
        return subset(nums,dp,n-1,k);
    }
}