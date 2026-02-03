class Solution {
    public boolean isTrionic(int[] nums) {
        int p=-1,n=nums.length;
        for(int i=0;i<n-2;i++){
            if(nums[i]>=nums[i+1]){
                p=i;
                break;
            }
        }
        if(p==-1 || p==0) return false;
        for(int i=p;i<n-1;i++){
            if(nums[i]<=nums[i+1]){
                p=i;
                break;
            }
        }
        if(p==1 || p==n-1) return false;
        for(int i=p;i<n-1;i++){
            if(nums[i]>=nums[i+1]){
                return false;
            }
        }
        return true;
    }
}