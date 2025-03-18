class Solution {
    public int maxFrequency(int[] nums, int k) {
        long sum=0;
        int l=0;
        Arrays.sort(nums);
        int freq=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum+k<(long)nums[r]*(r-l+1)){
                sum-=nums[l];
                l++;
            }
            freq=Math.max(freq,r-l+1);
        }
        return freq;
    }
}