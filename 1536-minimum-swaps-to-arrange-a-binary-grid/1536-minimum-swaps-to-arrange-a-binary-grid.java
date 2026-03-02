class Solution {
    public int minSwaps(int[][] grid) {
        // ADJACENT ROWS SWAP
        int n=grid.length;
        int trail[]=new int[n];
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==0) c++;
                else break;
            }
            trail[i]=c;
        }
        int swaps=0;
        for(int i=0;i<n;i++){
            int needed=n-i-1;
            int j=i;
            while(j<n && trail[j]<needed) j++;
            if(j==n) return -1;
            while(j>i){
                int t=trail[j];
                trail[j]=trail[j-1];
                trail[j-1]=t;
                swaps++;
                j--;
            }
        }
        return swaps;
    }
}

// Approach (Greedy + Adjacent Row Swaps)
// Count trailing zeros in each row.
// For each row index i, we need:
// trailingZeros >= n - i - 1
// If current row doesn’t satisfy it:
// Find a row below that does.
// Bring it up using adjacent swaps.
// Count the swaps.
// If no valid row exists → return -1.