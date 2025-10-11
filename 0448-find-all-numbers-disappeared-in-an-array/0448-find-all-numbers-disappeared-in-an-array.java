class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        // Step 1: Mark numbers present by making their corresponding index negative
        for(int i=0;i<nums.length;i++){
            int idx=Math.abs(nums[i])-1;
            if(nums[idx]>0) nums[idx]=-nums[idx];
        }
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]>0) ans.add(i+1);
        }
        return ans;
    }
}

// class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
//         for (int i = 1; i <= nums.length; i++) ans.add(i);
//         for (int i = 0; i < nums.length; i++) {
//             // Remove by value, not by index
//             ans.remove(Integer.valueOf(nums[i]));
//         }
//         return ans;
//     }
// }
