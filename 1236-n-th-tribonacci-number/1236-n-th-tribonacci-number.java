class Solution {
    int dp[]=new int[38];
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        if(dp[n]!=0) return dp[n];
        return dp[n]=tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }
}
// class Solution {
//     public int tribonacci(int n) {
//         if(n==0) return 0;
//         if(n==1 || n==2) return 1;
//         return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
//     }
// }

// class Solution {
//     public int tribonacci(int n) {
//         if (n == 0) return 0;
//         if (n == 1 || n == 2) return 1;
//         int a = 0, b = 1, c = 1; // T0, T1, T2
//         for (int i = 3; i <= n; i++) {
//             int next = a + b + c;
//             a = b;
//             b = c;
//             c = next;
//         }
//         return c;
//     }
// }
