class Solution {
    public int pivotIndex(int[] nums) {
        int tsum=0;
        for(int x: nums) tsum+=x;
        int leftSum=0;
        for(int i=0;i<nums.length;i++){
            if(leftSum*2==tsum-nums[i]) return i;
            leftSum+=nums[i];
        }
        return -1;
    }
}

// class Solution {
//     public int pivotIndex(int[] nums) {
//         int totalSum = 0;
//         int leftsum = 0;
//         for (int ele : nums)
//             totalSum += ele;
//         for (int i = 0; i < nums.length; leftsum += nums[i++])
            
//             if (leftsum * 2 == totalSum - nums[i])
//                 return i;       
//         return -1;      
//     }
// }

// class Solution {
//     public int pivotIndex(int[] nums) {
//       if(nums.length == 0) return - 1;
//       int leftSum = 0, rightSum = 0;
//       for(int num : nums) 
//           rightSum += num;

//       for(int i = 0; i < nums.length; i ++) {
//         rightSum -= nums[i];
//         if(rightSum == leftSum) return i;
//         leftSum += nums[i];
//       }
//       return - 1;
//     }
// }