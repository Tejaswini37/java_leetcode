class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int s=0;
        int m=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            s+=nums[i];
            if(s>m) m=s;
            if(s<0) s=0;
        }
        return m;
    }
}