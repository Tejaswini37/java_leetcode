class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int count=1;
        int last=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(last<pairs[i][0]){
                last=pairs[i][1];
                count++;
            }
        }
        return count;
    }
}