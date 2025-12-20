class Solution {
    // public int helper(int start,int end,int nums[]){
    //     if(start==end) return nums[start]; //only 2 elements
    //     int dp[]=new int[nums.length];
    //     dp[start]=nums[start];
    //     dp[start+1]=Math.max(nums[start+1],nums[start]);
    //     for(int i=start+2;i<=end;i++){
    //         dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);
    //     }
    //     return dp[end];
    // }
    public int helper(int l,int r,int nums[]){
        int prev=0, cur=0;
        for(int i=l;i<=r;i++){
            int temp=Math.max(cur, prev+nums[i]);
            prev=cur;
            cur=temp;
        }
        return cur;
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        return Math.max(helper(0,n-2,nums),helper(1,n-1,nums));
    }
}