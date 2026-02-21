// class Solution {
//     public int countPrimeSetBits(int left, int right) {
        
//     }
// }
// // Manually count set bits
//     private int countSetBits(int n) {
//         int count = 0;
        
//         while (n > 0) {
//             count += (n & 1);  // check last bit
//             n >>= 1;           // right shift
//         }
        
//         return count;
//     }
// class Solution {
//     public int countPrimeSetBits(int left, int right) {
//         int count = 0;
        
//         for (int i = left; i <= right; i++) {
//             int setBits = Integer.bitCount(i);
//             if (isPrime(setBits)) {
//                 count++;
//             }
//         }
        
//         return count;
//     }
    
//     private boolean isPrime(int n) {
//         if (n < 2) return false;
        
//         for (int i = 2; i * i <= n; i++) {
//             if (n % i == 0) return false;
//         }
        
//         return true;
//     }
// }
class Solution {
    
    public int countPrimeSetBits(int left, int right) {
        int count = 0;
        
        for (int i = left; i <= right; i++) {
            int setBits = countSetBits(i);
            
            if (isPrime(setBits)) {
                count++;
            }
        }
        
        return count;
    }
    
    // Manually count set bits
    private int countSetBits(int n) {
        int count = 0;
        
        while (n > 0) {
            n=n&(n-1); // removes lowest set bit
            count++;
        }
        
        return count;
    }
    
    // Check if number is prime
    private boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}