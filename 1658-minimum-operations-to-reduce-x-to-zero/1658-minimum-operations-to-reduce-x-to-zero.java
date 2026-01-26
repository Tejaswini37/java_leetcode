class Solution {
    public int minOperations(int[] nums, int x) {
        // Instead of thinking: “remove elements from ends”
        // Think this:  “keep a middle subarray whose sum = totalSum − x”
        // find longest subarray with given sum then subtract
        int total=0;
        for(int n : nums) total+=n;
        int tar=total-x;
        if(tar<0) return -1;
        if(tar==0) return nums.length;
        int left=0, sum=0, maxlen=-1;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(sum>tar){
                sum-=nums[left++];
            }
            if(sum==tar)
                maxlen=Math.max(maxlen,r-left+1);
        }
        return maxlen==-1 ? -1 : nums.length-maxlen;
    }
}

  