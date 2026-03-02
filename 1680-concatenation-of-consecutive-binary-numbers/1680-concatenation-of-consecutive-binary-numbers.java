class Solution {
    public int concatenatedBinary(int n) {
        long res=0;
        int bitlen=0;
        int MOD=1_000_000_007;
        for(int i=1;i<=n;i++){
            // if i is power of 2 , increase bit length
            if((i & (i-1))==0) bitlen++;
            res=((res<<bitlen)+i)%MOD;
        }
        return (int) res;
    }
}
