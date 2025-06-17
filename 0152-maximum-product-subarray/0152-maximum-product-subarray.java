class Solution {
    public int maxProduct(int[] nums) {
        //A minimum product (negative value) can become the maximum product if another negative is encountered.
        //currMax → the maximum product ending at the current index
        //currMin → the minimum product ending at the current index
        int curmin=nums[0],curmax=nums[0],sum=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int t=curmin;
                curmin=curmax;
                curmax=t;
            }
            curmin=Math.min(nums[i],nums[i]*curmin);
            curmax=Math.max(nums[i],nums[i]*curmax);
            sum=Math.max(sum,curmax);
        }
        return sum;
    }
}