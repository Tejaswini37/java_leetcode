class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int moves[]=new int[n*n+1];
        Arrays.fill(moves,-1);
        boolean leftToRight=true;
        int idx=1;
        for(int i=n-1;i>=0;i--){
            if(leftToRight){
                for(int j=0;j<n;j++){
                    moves[idx++]=board[i][j];
                }
            }
            else{
                //  12 11 10 9 8 7   <--
                for(int j=n-1;j>=0;j--){
                    moves[idx++]=board[i][j];
                }
            }
            leftToRight=!leftToRight;
        }
        Queue<int[]> q=new LinkedList<>();
        boolean vis[]=new boolean[n*n+1];
        q.add(new int[]{1,0});
        while(!q.isEmpty()){
            int b[]=q.poll();
            int square=b[0];
            int rolls=b[1];
            if(square==n*n) return rolls;
            for(int dice=1;dice<=6;dice++){
                int nextsquare=square+dice;
                if(nextsquare>n*n) break;
                if(moves[nextsquare]!=-1) nextsquare=moves[nextsquare];
                if(!vis[nextsquare]){
                    vis[nextsquare]=true;
                    q.add(new int[]{nextsquare,rolls+1});
                }
            }
        }
        return -1;
        
    }
}
// Steps

// Convert board coordinates (r, c) ↔ board number.

// Square numbers start at bottom-left and snake row direction alternates.

// BFS starting from square 1.

// For each number cur:

// Try dice rolls 1-6.

// Move to next = cur + dice.

// If board has ladder/snake, jump to that.

// If unvisited, push into queue.

// Keep track of moves (levels in BFS).

// Return moves if you reach n*n. If impossible, return -1.
// class Solution {
//     public int snakesAndLadders(int[][] board) {
//         int n = board.length;
//         boolean[] visited = new boolean[n * n + 1];
//         Queue<Integer> q = new LinkedList<>();
//         q.add(1);
//         visited[1] = true;
//         int moves = 0;

//         while (!q.isEmpty()) {
//             int size = q.size();
//             for (int i = 0; i < size; i++) {
//                 int cur = q.poll();
//                 if (cur == n * n) return moves;

//                 for (int dice = 1; dice <= 6; dice++) {
//                     int next = cur + dice;
//                     if (next > n * n) break;

//                     int[] pos = getCoordinates(next, n);
//                     int r = pos[0], c = pos[1];

//                     if (board[r][c] != -1) {
//                         next = board[r][c];
//                     }

//                     if (!visited[next]) {
//                         visited[next] = true;
//                         q.add(next);
//                     }
//                 }
//             }
//             moves++;
//         }
//         return -1;
//     }

//     // Converts square number to board coordinates
//     private int[] getCoordinates(int num, int n) {
//         int row = (num - 1) / n;
//         int col = (num - 1) % n;
//         int r = n - 1 - row;
//         int c = (row % 2 == 0) ? col : (n - 1 - col);
//         return new int[]{r, c};
//     }
// }
