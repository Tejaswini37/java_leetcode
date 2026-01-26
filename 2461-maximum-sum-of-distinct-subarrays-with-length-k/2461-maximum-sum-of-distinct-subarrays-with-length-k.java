class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> hm=new HashMap<>();
        long sum=0, maxSum=0;
        int l=0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            hm.put(nums[r],hm.getOrDefault(nums[r],0)+1);
            while(r-l+1>k){// shrink if big
                sum-=nums[l];
                hm.put(nums[l],hm.get(nums[l])-1);
                if(hm.get(nums[l])==0) hm.remove(nums[l]);
                l++;
            }
            // if valid
            if(r-l+1==k && hm.size()==k){
                maxSum=Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }
}
