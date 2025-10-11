class Solution {
    public int arraySign(int[] nums) {
        int p=1;
        for(int n:nums) {
            if(n==0) return 0;
            if(n<0) p=-p;
        }
        return p;
    }
}
// class Solution {
//     public int arraySign(int[] nums) {
//         int negativeCount = 0;

//         for (int n : nums) {
//             if (n == 0) return 0;        // if any number is zero, product is zero
//             if (n < 0) negativeCount++;  // count how many negatives
//         }

//         // If negative count is odd → product is negative
//         if (negativeCount % 2 == 1) return -1;
//         else return 1;
//     }
// }
