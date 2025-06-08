class Solution {
    public int helper(int i,int[] nums,int dp[]){
        if(i<0) return 0;
        if(i==0) return nums[0];
        if(dp[i]!=-1) return dp[i];
        int pick=nums[i]+helper(i-2,nums,dp);
        int notpick=0+helper(i-1,nums,dp);

        return dp[i]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0]=nums[0];
        //dp[1]=nums[1]; constraints  min length of array=1 can't take dp[1]
        for(int i=1;i<nums.length;i++){
            //dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            int p=nums[i];
            if(i>1) p+=dp[i-2];
            int np=dp[i-1];
            dp[i]=Math.max(p,np);
        }
        return dp[nums.length-1];
    }
}

//memo
// class Solution {
//     public int helper(int i,int[] nums,int dp[]){
//         if(i<0) return 0;
//         if(i==0) return nums[0];
//         if(dp[i]!=-1) return dp[i];
//         int pick=nums[i]+helper(i-2,nums,dp);
//         int notpick=0+helper(i-1,nums,dp);

//         return dp[i]=Math.max(pick,notpick);
//     }
//     public int rob(int[] nums) {
//         int dp[]=new int[nums.length];
//         Arrays.fill(dp,-1);
//         return helper(nums.length-1,nums,dp);
//     }
// }


// class Solution {
//     public int helper(int i,int[] nums){
//         if(i<0) return 0;
//         if(i==0) return nums[0];
//         int pick=nums[i]+helper(i-2,nums);
//         int notpick=0+helper(i-1,nums);
//         return Math.max(pick,notpick);
//     }
//     public int rob(int[] nums) {
//         return helper(nums.length-1,nums);
//     }
// }


