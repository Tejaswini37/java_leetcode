class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n=9;
        Set<String> seen=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char ch=board[i][j];
                if(ch=='.') continue;
                if(!seen.add(ch+" in row "+i) ||
                    !seen.add(ch+" in col "+j) ||
                    !seen.add(ch+" in box "+(i/3)+" "+(j/3))){
                        return false;
                    }
            }
        }
        return true;
    }
}


// class Solution {
//     public static boolean isSafe(char board[][],int r,int c,int k){
//         int n=board.length;
//         char ch=(char)(k+'0');
//         for (int i = 0; i < n; i++) {
//             if (board[r][i] == ch) return false; // row check
//             if (board[i][c] == ch) return false; // col check
//         }
//         int sqrt=(int)(Math.sqrt(n));
//         int rowStart=r-r%sqrt;
//         int colStart=c-c%sqrt;
//         for(int i=rowStart;i<rowStart+sqrt;i++){
//             for(int j=colStart;j<colStart+sqrt;j++){
//                 if(board[r][c]==ch) return false;
//             }
//         }
//         return true;
        
//     }
//     public boolean isValidSudoku(char[][] board) {
//         int n=board.length;
//         int r=-1,c=-1;
//         boolean solved=true;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(board[i][j]=='.'){
//                     r=i;
//                     c=j;
//                     solved=false;
//                     break;
//                 }
//             }
//         }
//         if(solved==true) return true;
//         for(int k=1;k<=9;k++){
//             if(isSafe(board,r,c,k)){
//                 board[r][c]=char(k+'0');
//                 if(isValidSudoku(board)) return true;
//                 board[r][c]='.';
//             }
//         }
//         return true;
//     }
// }