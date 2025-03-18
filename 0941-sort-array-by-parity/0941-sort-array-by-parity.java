class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int l=0;
        int h=nums.length-1;
        while(l<h){
            while(l<nums.length && nums[l]%2==0) l++;
            while(h>=0 && nums[h]%2==1) h--;
            if(l<h){
            int t=nums[l];
            nums[l]=nums[h];
            nums[h]=t;
            }
            
        }
        return nums;
    }
}