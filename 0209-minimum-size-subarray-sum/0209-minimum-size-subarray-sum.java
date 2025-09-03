class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,i=0,n=nums.length;
        int minlen=Integer.MAX_VALUE;
        int sum=0;
        while(i<n){
            sum+=nums[i];
            while(sum>=target){
                minlen=Math.min(minlen,i-left+1);
                sum-=nums[left];
                left++;
            }
            i++;
        }
        return minlen==Integer.MAX_VALUE?0:minlen;
    }
}