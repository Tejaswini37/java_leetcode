class Solution {
    public int[] findErrorNums(int[] nums) {
//         Index = x - 1
// First time you see x → mark nums[x-1] as negative
// If nums[x-1] is already negative → x is the duplicate
// 👉 Array indices start from 0, but values start from 1.
// So we convert value → index using x - 1.
        int dup=-1,mis=-1;
        for(int i=0;i<nums.length;i++){
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]<0) dup=Math.abs(nums[i]);
            else nums[idx]=-nums[idx];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                mis=i+1;
                break;
            }
        }
        return new int[]{dup,mis};

        
    }
}
// class Solution {
//     public int[] findErrorNums(int[] nums) {

//         int n = nums.length;
//         int[] count = new int[n + 1];

//         // count frequencies
//         for (int x : nums) {
//             count[x]++;
//         }

//         int dup = -1, miss = -1;

//         // find duplicate and missing
//         for (int i = 1; i <= n; i++) {
//             if (count[i] == 2) dup = i;
//             if (count[i] == 0) miss = i;
//         }

//         return new int[]{dup, miss};
//     }
// }
