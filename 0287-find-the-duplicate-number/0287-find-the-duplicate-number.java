class Solution {
    public int findDuplicate(int[] nums) {
        int slow=nums[0];
        int fast=nums[0];
        do{
            slow=nums[slow];
            fast=nums[nums[fast]];

        }while(slow!=fast);
        slow=nums[0];
        while(slow!=fast){
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
}
// Array: nums = [3,1,3,4,2]

// This maps like a linked list:

// 0 → 3 → 4 → 2 → 3 → 4 → 2 → 3 → ... ← forms a cycle

// Using Floyd’s Algorithm:

// Tortoise and Hare meet inside the cycle

// Then both move at the same pace to find the entrance: 3 is the duplicate.



// class Solution {
//     public int findDuplicate(int[] nums) {
//         int low = 1;
//         int high = nums.length - 1; // since nums.length = n + 1 and values are from 1 to n

//         while (low < high) {
//             int mid = low + (high - low) / 2;

//             // Count how many numbers are ≤ mid
//             int count = 0;
//             for (int num : nums) {
//                 if (num <= mid) {
//                     count++;
//                 }
//             }

//             if (count > mid) {
//                 // Duplicate is in the range [low, mid]
//                 high = mid;
//             } else {
//                 // Duplicate is in the range [mid + 1, high]
//                 low = mid + 1;
//             }
//         }

//         return low; // or high, both are equal at this point
//     }
// }


// If all numbers were unique in range [1, mid], there should be at most mid numbers ≤ mid.
// If count > mid, there's a duplicate in that range.
