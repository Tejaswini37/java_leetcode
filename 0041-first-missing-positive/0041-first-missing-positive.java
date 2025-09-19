class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int tar=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<1 || (i>0 && nums[i]==nums[i-1])) continue;
            else if(nums[i]==tar) tar++;
            else return tar;
        }
        return tar;
    }
}