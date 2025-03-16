class Solution {
    public int[] sortedSquares(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int ans[]=new int[nums.length];
        int i=nums.length-1;
        while(l<=r){
            if(Math.abs(nums[l])<Math.abs(nums[r])){
                ans[i]=nums[r]*nums[r];
                r--;
            }
            else{
                ans[i]=nums[l]*nums[l];
                l++;
            }
            i--;
        }
        return ans;

        
    }
}