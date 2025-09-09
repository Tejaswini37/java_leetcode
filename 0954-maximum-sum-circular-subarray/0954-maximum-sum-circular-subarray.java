class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       int total=0;
       int curmax=0, maxsum=nums[0];
       int curmin=0, minsum=nums[0]; 
       for(int n : nums){
        total+=n;
        curmin=Math.min(n,curmin+n);
        minsum=Math.min(minsum,curmin);

        curmax=Math.max(curmax+n,n);
        maxsum=Math.max(curmax,maxsum);
       }
       if(maxsum<0) return maxsum;
       return Math.max(total-minsum,maxsum);
    }
}
// Normal case (no wrap):
// Just find max subarray sum with Kadane.

// Wrap case:
// If subarray wraps, then
// maxSum = totalSum - minSubarraySum

// Handle corner case:
// If all numbers are negative, the wrap formula becomes invalid (because it picks empty subarray). In that case, just return normal Kadane’s max.