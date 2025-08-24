class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int c=1,x=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]==x) c++;
            else{
                c--;
            }
            if(c==0) {
                x=nums[i];
                c=1;}
        }
        return x;
        
    }
}