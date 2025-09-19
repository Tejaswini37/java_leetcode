class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixCount=new HashMap<>();
        int sum=0;
        prefixCount.put(0,1);
        int count=0;
        for(int n: nums){
            sum+=n;
            if(prefixCount.containsKey(sum-k)){
                count+=prefixCount.get(sum-k);
            }
            prefixCount.put(sum,prefixCount.getOrDefault(sum,0)+1);
        }
        return count;
    }
}

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int n = nums.length;
//         int count = 0;
//         for (int i = 0; i < n; i++) {
//             int sum = 0;
//             for (int j = i; j < n; j++) {
//                 sum += nums[j];
//                 if (sum == k) count++;
//             }
//         }
//         return count;
//     }
// }
