class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxEnding=0,minEnding=0;
        int maxsum=0,minsum=0;
        for(int x : nums){
            maxEnding=Math.max(x,maxEnding+x);
            maxsum=Math.max(maxsum,maxEnding);

            minEnding=Math.min(x,minEnding+x);
            minsum=Math.min(minsum,minEnding);
        }
        return Math.max(maxsum,Math.abs(minsum));
    }
}
// max |sum| = max(maxSubarraySum, |minSubarraySum|)
