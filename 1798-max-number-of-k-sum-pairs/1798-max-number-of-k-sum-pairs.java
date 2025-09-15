class Solution {
    public int maxOperations(int[] nums, int k) {
        int left=0,right=nums.length-1;
        Arrays.sort(nums);
        int c=0;
        while(left<right){
            if(nums[left]+nums[right]==k){
                left++;
                right--;
                c++;
            }
            else if(nums[left]+nums[right]>k) right--;
            else left++;
        }
        return c;
    }
}