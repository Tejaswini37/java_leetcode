// class Solution {
//     public int longestArithSeqLength(int[] nums) {
        
//     }
// }
public class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int diff = nums[j] - nums[i];
                int len = 2 + helper(nums, j, diff);
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }

    // Recursive helper to extend the sequence
    private int helper(int[] nums, int index, int diff) {
        int max = 0;
        for (int i = index+1; i < nums.length; i++) {
            if (nums[i] - nums[index] == diff) {
                max = Math.max(max, 1 + helper(nums, i, diff));
                break;
            }
        }
        return max;
    }
}
