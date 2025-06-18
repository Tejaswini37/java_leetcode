class Solution {
    public boolean isHappy(int n) {

        while(true){
            if(n==1) return true;
            if(n==4) return false;
            int temp=0;
            int x=0;
            while(n>0){
                temp=n%10;
                x+=temp*temp;
                n=n/10;
            }
            n=x;
        }
    }
}