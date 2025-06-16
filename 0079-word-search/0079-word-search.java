class Solution {
    public boolean bt(int idx,int r,int c,String s,char[][] board,int n,int m){
        if(idx==s.length()) return true;
        if(r<0 || c<0 || r>=n || c>=m || board[r][c]!=s.charAt(idx)) return false;
        board[r][c]='*';
        int di[]={1,-1,0,0};
        int dj[]={0,0,1,-1};
        for(int i=0;i<4;i++){
            if(bt(idx+1,r+di[i],c+dj[i],s,board,n,m)) return true;
        }
        board[r][c]=s.charAt(idx);
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    boolean ans=bt(0,i,j,word,board,n,m);
                    if(ans) return true;
                }
            }
        }
        return false;
    }
}