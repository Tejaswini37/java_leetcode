class Solution {
    public long gridGame(int[][] grid) {
        int n=grid[0].length;
        long r1[]=new long[n];
        long r2[]=new long[n];
        r1[0]=grid[0][0];
        r2[0]=grid[1][0];
        for(int i=1;i<n;i++){
            r1[i]=r1[i-1]+grid[0][i];
            r2[i]=r2[i-1]+grid[1][i];
        }
        long ans=Long.MAX_VALUE;
        for(int c=0;c<n;c++){
            long topremaining=(c==n-1)?0: r1[n-1]-r1[c];
            long bottomremaining=(c==0)?0: r2[c-1];
            long robot2=Math.max(topremaining,bottomremaining);
            // Robot-1 moves first and knows Robot-2 will act greedily.
            // So Robot-1 asks:
            // “No matter what, Robot-2 will take the bigger remaining part.How can I make that bigger part as small as possible?”
// That’s the key idea.
            // Robot-1 chooses column c such that:
            // max(topRightSum, bottomLeftSum) is as small as possible.
            ans=Math.min(ans,robot2);
        }
        return ans;
    }
}
// Robot-2 can choose only ONE of these two regions:
// Top-right part
// Bottom-left part