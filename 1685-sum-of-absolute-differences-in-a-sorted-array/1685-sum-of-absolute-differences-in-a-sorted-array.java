class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        int total=0;
        for(int x : nums) total+=x;
        int prefixsum=0;
        for(int i=0;i<n;i++){
            int leftsum=nums[i]*i-prefixsum;
            int rightsum=(total-prefixsum-nums[i])-(n-i-1)*nums[i];
            res[i]=leftsum+rightsum;
            prefixsum+=nums[i];
        }
        return res;
    }
}
