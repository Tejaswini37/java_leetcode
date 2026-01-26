class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int l=0, ans=0, n=nums.length;
        for(int r=0;r<n;r++){
            while(nums[r]-nums[l]>2*k){
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}
// After operations:
// Each number x can be turned into any value in [x−k, x+k]
// Two numbers can become equal if their ranges overlap
// nums[l] can go up to nums[l] + k
// nums[r] can go down to nums[r] − k
// Overlap exists if:
// nums[r] − k ≤ nums[l] + k
// ⇒ nums[r] − nums[l] ≤ 2k
