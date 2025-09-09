class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        for(int i=n-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        // we come here only if number is 9 , 99, 999
        // for this ans id 10 100 1000
        int res[]=new int[n+1];
        res[0]=1;
        return res;
    }
}