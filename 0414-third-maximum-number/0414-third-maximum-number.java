class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set=new TreeSet<>();
        for(int n:nums){
            set.add(n);
            if(set.size()>3) set.pollFirst();
        }
        return set.size()==3 ? set.first() : set.last();
    }
}
// class Solution {
//     public int thirdMax(int[] nums) {
//         Arrays.sort(nums);
//         int distinctFound = 1;
        
//         for (int i = nums.length - 1; i > 0; i--) {
//             if (nums[i] != nums[i - 1]) {
//                 distinctFound++;
//             }
//             if (distinctFound == 3) {
//                 return nums[i - 1];
//             }
//         }
        
//         return nums[nums.length - 1];
//     }
// }

// class Solution {
//     public int thirdMax(int[] nums) {
//         Long max1 = null, max2 = null, max3 = null;

//         for (int n : nums) {
//             long num = n;

//             // Skip duplicates
//             if ((max1 != null && num == max1) ||
//                 (max2 != null && num == max2) ||
//                 (max3 != null && num == max3)) {
//                 continue;
//             }

//             if (max1 == null || num > max1) {
//                 max3 = max2;
//                 max2 = max1;
//                 max1 = num;
//             } else if (max2 == null || num > max2) {
//                 max3 = max2;
//                 max2 = num;
//             } else if (max3 == null || num > max3) {
//                 max3 = num;
//             }
//         }

//         return max3 == null ? max1.intValue() : max3.intValue();
//     }
// }

