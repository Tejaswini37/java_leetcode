class Solution {
    private int c=0;
    public boolean isSafe(int board[][],int r,int c,int n){
        for(int i=0;i<n;i++){
            // left row
            if(board[r][i]==1) return false;
        }
        for(int i=r,j=c;i>=0 && j>=0;i--,j--){
            //left up diagonal
            if(board[i][j]==1) return false;
        }
        for(int i=r, j=c; j>=0 && i<n ; i++,j--){
            if(board[i][j]==1) return false;
        }
        return true;
    }
    public void solve(int board[][],int col,int n){
        if(col==n){
            c++;
            return;
        }
        for(int i=0;i<n;i++){
            if(isSafe(board,i,col,n)){
                board[i][col]=1;
                solve(board,col+1,n);
                board[i][col]=0;
            }
        }
        return;
    }
    public int totalNQueens(int n) {
        int board[][]=new int[n][n];
        solve(board,0,n);
        return c;
    }
}