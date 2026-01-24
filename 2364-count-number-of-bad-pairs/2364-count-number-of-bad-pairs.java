class Solution {
    public long countBadPairs(int[] nums) {
        Map<Long,Long> hm=new HashMap<>();
        long good=0;
        for(int i=0;i<nums.length;i++){
            long key=nums[i]-i;
            long freq=hm.getOrDefault(key,0L);
            good+=freq;
            hm.put(key,freq+1);
        }
        int n=nums.length;
        long total=1L*n*(n-1)/2;
        return total-good;
    }
}
// bad pair means
// j - i == nums[j] - nums[i]
// ⇒ nums[j] - j == nums[i] - i

// totalPairs = n * (n - 1) / 2
// subtrack good
