class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        long sum=0;
        for(int num : nums) sum+=num;
        // try forming polygon with largest possible sides
        for(int i=n-1;i>=2;i--){
            if(nums[i]<sum-nums[i]) return sum;
            sum-=nums[i]; // remove largest
        }
        return -1;

    }
}
