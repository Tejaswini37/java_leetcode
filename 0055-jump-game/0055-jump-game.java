class Solution {
    public boolean canJump(int[] nums) {
        int max=nums[0];
        if(nums.length==1) return true;
        if(max==0) return false;
        for(int i=1;i<nums.length;i++){
            max=Math.max(max-1,nums[i]);
            if(i+max>=nums.length-1) return true;
            if(max==0) return false;
            
        }
        return false;
    }
}