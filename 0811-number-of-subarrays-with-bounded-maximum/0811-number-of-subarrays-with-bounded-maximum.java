class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int c=0;
        int l=0,r=0;
        int prev=0;
        while(r<nums.length){
            
            if(nums[r]>=left && nums[r]<=right) {
                prev=r-l+1;
                c+=prev;
            }
            else if(nums[r]<left) c+=prev;
            else{
                l=r+1;
                prev=0;
            }
            r++;
        }
        return c;
    }
}