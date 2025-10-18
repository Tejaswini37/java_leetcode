class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==divisor ) return 1;
        if(dividend == Integer.MIN_VALUE && divisor==-1){
            return Integer.MAX_VALUE;
        }
        if(divisor == 1) return dividend;
        if(dividend == -1) return -dividend;
        int sign=1;
        if(dividend>0 && divisor<0) sign = -1;
        if(dividend<0 && divisor>0) sign = -1;
        long n=Math.abs((long)dividend);
        long d=Math.abs((long)divisor);
        long ans=0,sum=0;
        while(sum+d<=n){
            ans++;
            sum+=d;
        }
        if(ans>Integer.MAX_VALUE && sign==1) return Integer.MAX_VALUE;
        if(ans>Integer.MAX_VALUE && sign==-1) return Integer.MIN_VALUE;
        return (int)ans*sign;
    }
}

// class Solution {
//     public int divide(int dividend, int divisor) {
//         if(dividend == divisor) return 1;
//         if (dividend == Integer.MIN_VALUE && divisor == -1) {
//             return Integer.MAX_VALUE;
//         }
//         if(divisor == 1) return dividend;
//         if(dividend == -1) return -dividend;
//         int sign = 1;
//         if(dividend>0 && divisor<0) sign = -1;
//         if(dividend<0 && divisor>0) sign = -1;

//         long n = Math.abs((long)dividend);
//         long d = Math.abs((long)divisor);
//         int ans = 0;
//         while(n>=d)
//         {
//             int p = 0;
//             while(n >= d<<p)
//             p++;

//             p--;
//             n -= d<<p;
//             ans += 1<<p;
//         }
//         if(ans>=Math.pow(2,31) && sign==1) return Integer.MAX_VALUE;
//         if(ans>=Math.pow(2,31) && sign==-1) return Integer.MIN_VALUE;

//         return ans*sign;
//     }
// }

// class Solution {
//      public int divide(int dividend, int divisor) {
//         if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE; //Cornor case when -2^31 is divided by -1 will give 2^31 which doesnt exist so overflow 
         
//         boolean negative = dividend < 0 ^ divisor < 0; //Logical XOR will help in deciding if the results is negative only if any one of them is negative
        
//         dividend = Math.abs(dividend);
//         divisor = Math.abs(divisor);
//         int quotient = 0, subQuot = 0;
        
//         while (dividend - divisor >= 0) {
//             for (subQuot = 0; dividend - (divisor << subQuot << 1) >= 0; subQuot++);
//             quotient += 1 << subQuot; //Add to the quotient
//             dividend -= divisor << subQuot; //Substract from dividend to start over with the remaining
//         }
//         return negative ? -quotient : quotient;
//     }
// }