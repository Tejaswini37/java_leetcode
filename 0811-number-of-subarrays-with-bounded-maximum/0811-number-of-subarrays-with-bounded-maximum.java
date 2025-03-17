class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int c=0;
        int l=0,r=0;
        int maxind=-1;
        while(r<nums.length){
            
            if(nums[r]>=left && nums[r]<=right) maxind=r;
            if(nums[r]>right){
                r++;
                l=r;
                maxind=-1;
                continue;
            }
            if(maxind!=-1) c+=maxind-l+1;
            r++;
        }
        return c;
    }
}