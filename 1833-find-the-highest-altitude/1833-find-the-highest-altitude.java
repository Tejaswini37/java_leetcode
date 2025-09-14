class Solution {
    public int largestAltitude(int[] gain) {
        int sum=0,max=0;
        for(int x: gain){
            sum+=x;
            max=Math.max(max,sum);
        }
        return max;
    }
}