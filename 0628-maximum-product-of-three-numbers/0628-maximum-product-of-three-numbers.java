class Solution {
    public int maximumProduct(int[] nums) {
        // Arrays.sort(nums);
        int n=nums.length;
        // return Math.max(nums[0]*nums[1]*nums[n-1],nums[n-1]*nums[n-2]*nums[n-3]);
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE,max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
        for(int x:nums){
            if(x>max1){
                max3=max2;
                max2=max1;
                max1=x;
            }
            else if(x>max2){
                max3=max2;
                max2=x;
            }
            else if(x>max3) max3=x;

            if(min1>x){
                min2=min1;
                min1=x;
            }
            else if(min2>x) min2=x;
        }
        return Math.max(max1*min1*min2,max1*max2*max3);
    }
}