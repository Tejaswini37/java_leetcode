class Solution {
    public int reverse(int x) {
        int f=x>0?1:-1;
        int ans=0;
        x=Math.abs(x);
        while(x>0){
            if(ans>Integer.MAX_VALUE/10) return 0;
            ans=ans*10+(x%10);
            
            x=x/10;
        }
        return f*ans;
    }
}