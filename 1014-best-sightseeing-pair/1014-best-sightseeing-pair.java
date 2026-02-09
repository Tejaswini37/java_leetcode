class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int bestLeft=values[0]+0;
        int ans=0;
        for(int j=1;j<values.length;j++){
            ans=Math.max(ans,bestLeft+values[j]-j);
            bestLeft=Math.max(bestLeft,values[j]+j);
        }
        return ans;
    }
}
// (values[i] + i) + (values[j] - j)
// Now notice:
// For a fixed j, you want the maximum (values[i] + i) where i < j
// So while scanning from left to right, keep track of the best left value so far