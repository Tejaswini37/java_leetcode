class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> hm=new HashMap<>();
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int tar=k-nums[i];
            if(hm.getOrDefault(tar,0) > 0 ){
                ans++;
                hm.put(tar,hm.get(tar)-1);
            }
            else hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        return ans;
    }
}
// class Solution {
//     public int maxOperations(int[] nums, int k) {
//         int left=0,right=nums.length-1;
//         Arrays.sort(nums);
//         int c=0;
//         while(left<right){
//             if(nums[left]+nums[right]==k){
//                 left++;
//                 right--;
//                 c++;
//             }
//             else if(nums[left]+nums[right]>k) right--;
//             else left++;
//         }
//         return c;
//     }
// }