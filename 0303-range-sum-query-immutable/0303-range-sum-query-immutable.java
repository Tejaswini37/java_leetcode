class NumArray {
    private int prefixsum[];
    public NumArray(int[] nums) {
        int n=nums.length;
        prefixsum=new int[n+1];
        for(int i=1;i<=n;i++){
            prefixsum[i]=prefixsum[i-1]+nums[i-1];
        }
    }
    
    public int sumRange(int left, int right) {
        return prefixsum[right+1]-prefixsum[left];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

//  class NumArray {

//     private int[] prefixSum;

//     public NumArray(int[] nums) {
//         int n = nums.length;
//         prefixSum = new int[n + 1];
        
//         prefixSum[0] = 0;
//         for (int i = 1; i <= n; i++) {
//             prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
//         }
//     }
    
//     public int sumRange(int left, int right) {
//         return prefixSum[right + 1] - prefixSum[left];
//     }
// }


// int[] nums;

// public NumArray(int[] nums) {
//     for(int i = 1; i < nums.length; i++)
//         nums[i] += nums[i - 1];
    
//     this.nums = nums;
// }

// public int sumRange(int i, int j) {
//     if(i == 0)
//         return nums[j];
    
//     return nums[j] - nums[i - 1];
// }
