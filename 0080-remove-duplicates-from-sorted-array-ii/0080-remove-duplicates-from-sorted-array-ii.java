class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<=2){
            return n;
        }

        int j = 2;
        for(int i=2; i<n; i++){
            if(nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}

// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int c=1,n=nums[0];
//         int j=1;
//         for(int i=1;i<nums.length;i++){
//             if(nums[i]==n && c<2){
//                 c++;
//                 nums[j++]=nums[i];
//             }
//             else if(nums[i]==n) continue;
//             else{
//                 c=1;
//                 n=nums[i];
//                 nums[j++]=nums[i];
//             }
//         }
//         return j;
//     }
// }