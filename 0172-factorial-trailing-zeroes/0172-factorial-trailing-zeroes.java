class Solution {
    public int trailingZeroes(int n) {
        // 10= 2*5
        // no(2) <no(5) so n(5) is ans
        int c=0;
        while(n>0){
            n=n/5;
            c+=n;
        }
        return c;
    }
}