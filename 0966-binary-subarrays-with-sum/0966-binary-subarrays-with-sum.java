class Solution {
    public static int atMost(int nums[],int k){
        int c=0;
        int i=0,j=0,sum=0;
        while(j<nums.length){
            sum+=nums[j];
            while(i<=j &&sum>k){
                sum-=nums[i];
                i++;
            }
          
            c+=(j-i+1);
            j++;
        }
        
        return c;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums,goal)-atMost(nums,goal-1);
    }
}