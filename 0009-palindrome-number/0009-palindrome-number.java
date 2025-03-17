class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int n=x;
        int ans=0;
        while(x>0){
            if(ans>Integer.MAX_VALUE/10) return false;
            ans=ans*10+x%10;
            x=x/10;
        }
        return n==ans?true:false;
    }
}