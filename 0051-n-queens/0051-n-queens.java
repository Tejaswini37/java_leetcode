class Solution {
    public static boolean issafe(int r,int c,char[][] nq,int n){
        for(int i=0;i<c;i++) {
            if(nq[r][i]=='Q') return false;
        }
        int i=r-1,j=c-1;
        while(i>=0 && j>=0){
            if(nq[i][j]=='Q') return false;
            i--;
            j--;
        }
        for( i=r+1,j=c-1;i<n && j>=0;i++,j--){
            if(nq[i][j]=='Q') return false;
        }
        return true;
    }
    public static void bt(int col,int n,char[][] nq,List<List<String>> ans){
        if(col==n){
            List<String> t=new ArrayList<>();
            for(char r[]:nq){
                t.add(new String(r));
            }
            ans.add(t);
            return;
        }
        for(int i=0;i<n;i++){
            if(issafe(i,col,nq,n)){
                nq[i][col]='Q';
                bt(col+1,n,nq,ans);
                nq[i][col]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char[][] nq=new char[n][n];
        for(char r[]:nq) Arrays.fill(r,'.');
        bt(0,n,nq,ans);
        return ans;
    }
}