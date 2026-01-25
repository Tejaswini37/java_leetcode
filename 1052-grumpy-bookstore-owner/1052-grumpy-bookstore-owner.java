class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int base=0;
        // customers already satisfoied;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0)
                base+=customers[i];
        }
        // sliding window for extra
        int extra=0, max=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==1)
                extra+=customers[i];
            if(i>=minutes && grumpy[i-minutes]==1){
                extra-=customers[i-minutes];
            }
            max=Math.max(max,extra);
        }
        return max+base;
    }
}
