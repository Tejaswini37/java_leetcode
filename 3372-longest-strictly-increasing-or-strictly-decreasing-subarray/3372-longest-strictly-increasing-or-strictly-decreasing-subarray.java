class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max=1;
        int longest=1;
        int i=1;
        while(i<nums.length){
            while(i<nums.length && nums[i]>nums[i-1]){
                longest++;
                i++;
            } 
            max=Math.max(max,longest);
            longest=1;
            while(i<nums.length && nums[i]<nums[i-1]){
                longest++;
                i++;
            }
            max=Math.max(max,longest);
            longest=1;
            while(i<nums.length && nums[i]==nums[i-1]) i++;
        }
        return max;
        
    }
}