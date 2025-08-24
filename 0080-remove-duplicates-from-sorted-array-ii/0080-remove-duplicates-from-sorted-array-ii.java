class Solution {
    public int removeDuplicates(int[] nums) {
        int c=1,n=nums[0];
        int j=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==n && c<2){
                c++;
                nums[j++]=nums[i];
            }
            else if(nums[i]==n) continue;
            else{
                c=1;
                n=nums[i];
                nums[j++]=nums[i];
            }
        }
        return j;
    }
}