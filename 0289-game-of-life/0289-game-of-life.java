class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length,n=board[0].length;
        int dirs[][]={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                int live=0;
                for(int d[]: dirs){
                    int nr=r+d[0], nc=c+d[1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && Math.abs(board[nr][nc])==1) 
                    live++;
                }
                // rule 1 or 3 : live cell dies
                if(board[r][c]==1 && (live<2 || live >3)){
                    board[r][c]=-1;  //live -> dead
                } 
                // rule  4: dead -> live
                if(board[r][c]==0 && live==3){
                    board[r][c]=2;  //live -> dead
                } 
            }
        }
        //  normalize board
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                if(board[r][c]>0) board[r][c]=1;
                else board[r][c]=0;
            }
        }
    }
}

