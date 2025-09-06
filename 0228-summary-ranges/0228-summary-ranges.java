class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        if(nums.length==0) return ans;
        int start=0,end=1;
        while(end<=nums.length){
            if(end==nums.length || nums[end]!=nums[end-1]+1){
                if(start!=end-1)
                ans.add(nums[start]+"->"+nums[end-1]);
                else ans.add(nums[start]+"");
                start=end;
            }
            end++;
        }
        // if(start!=end-1)
        // ans.add(nums[start]+"->"+nums[end-1]);
        // else ans.add(nums[start]+"");
        return ans;
    }
}
// class Solution {
//     public List<String> summaryRanges(int[] nums) {
//         List<String> ans = new ArrayList<>();
//         if (nums.length == 0) return ans;

//         int start = 0;
//         for (int i = 1; i <= nums.length; i++) {
//             // sequence break OR end of array
//             if (i == nums.length || nums[i] != nums[i - 1] + 1) {
//                 if (start == i - 1) {
//                     ans.add(nums[start] + "");
//                 } else {
//                     ans.add(nums[start] + "->" + nums[i - 1]);
//                 }
//                 start = i;
//             }
//         }
//         return ans;
//     }
// }
