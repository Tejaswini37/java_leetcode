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