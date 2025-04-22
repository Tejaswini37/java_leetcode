class Solution {
    public int jump(int[] nums) {
        int reach=0,c=0,last=0; //maxreach
        for(int i=0;i<nums.length-1;i++){
            reach=Math.max(reach,i+nums[i]);
            if(i==last) {
                last=reach;
                c++;
            }
        }
        return c;
    }
}
