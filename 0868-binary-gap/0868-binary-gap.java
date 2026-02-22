class Solution {
    public int binaryGap(int n) {
        int idx=0; // it is last index;
        int last=-1;
        int max=0;
        while(n>0){
            if(n%2==1){
                if(last!=-1){
                    max=Math.max(max,idx-last);
                }
                last=idx;
            }
            idx++;
            n/=2;
        }
        return max;
    }
}