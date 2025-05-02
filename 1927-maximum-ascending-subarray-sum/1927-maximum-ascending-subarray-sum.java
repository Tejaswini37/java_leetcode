class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum=nums[0];
        int max=sum;
        int i=1;
        while(i<nums.length){
            while(i<nums.length && nums[i]>nums[i-1]){
                sum+=nums[i];
                i++;
            }
            max=Math.max(max,sum);
            if(i<nums.length)sum=nums[i];
            i++;
        }
        return max;
    }
}