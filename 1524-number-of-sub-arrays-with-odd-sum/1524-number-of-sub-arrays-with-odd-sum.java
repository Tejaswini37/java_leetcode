class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD=1_000_000_007;
        long ans=0;
        int even=1;
        int odd=0;
        int sum=0;
        for(int x : arr){
            sum+=x;
            if((sum&1)==0){
                ans+=odd;
                even++;
            }
            else{
                ans+=even;
                odd++;
            }
            ans%=MOD;
        }
        return (int)ans;
    }
}
// Using prefix sum parity: an odd subarray is formed when two prefix sums have different parity. Count even and odd prefixes in one pass.
// Odd → pair it with all previous even prefixes
// Even → pair it with all previous odd prefixes

// class Solution {
//     public int numOfSubarrays(int[] arr) {

//         final int MOD = 1_000_000_007;

//         long ans = 0;
//         int even = 1;  // prefix sum = 0
//         int odd = 0;

//         int sum = 0;

//         for (int x : arr) {
//             sum += x;

//             if ((sum & 1) == 0) {          // even sum
//                 ans += odd;
//                 even++;
//             } else {                        // odd sum
//                 ans += even;
//                 odd++;
//             }

//             ans %= MOD;
//         }

//         return (int) ans;
//     }
// }
