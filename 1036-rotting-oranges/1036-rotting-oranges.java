class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int rows=grid.length;
        int cols=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int oranges=0;
        //put the position of all rotten orangesin queue
        //count no of fresh oranges
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2) q.add(new int[]{i,j});
                if(grid[i][j]!=0) oranges++;
            }
        }
        int c=0;
        int dirs[][]={{1,0},{-1,0},{0,1},{0,-1}};
        int countMin=0;
        // bfs starting initially with rotten oranges
        while(!q.isEmpty()){
            int size=q.size();
            c+=size;
            for(int i=0;i<size;i++){
                int point[]=q.poll();
                for(int d[]: dirs){
                    int nr=point[0]+d[0];
                    int nc=point[1]+d[1];
                    if(nr<0 || nc<0 || nr>=rows || nc>=cols || grid[nr][nc]!=1) continue;
                    grid[nr][nc]=2;
                    q.offer(new int[]{nr,nc});
                }
            }
            if(!q.isEmpty()) countMin++;
        }
        if(c==oranges) return countMin;
        else return -1;
    }
}

//         if(count_fresh == 0) return 0;
//         int countMin = 0, cnt = 0;
//         int dx[] = {0, 0, 1, -1};
//         int dy[] = {1, -1, 0, 0};
        
//         //bfs starting from initially rotten oranges
//         while(!queue.isEmpty()) {
//             int size = queue.size();
//             cnt += size; 
//             for(int i = 0 ; i < size ; i++) {
//                 int[] point = queue.poll();
//                 for(int j = 0;j<4;j++) {
//                     int x = point[0] + dx[j];
//                     int y = point[1] + dy[j];
                    
//                     if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == 0 || 
//                     grid[x][y] == 2) continue;
                    
//                     grid[x][y] = 2;
//                     queue.offer(new int[]{x , y});
//                 }
//             }
//             if(queue.size() != 0) {
//                 countMin++;
//             }
//         }
//         return count_fresh == cnt ? countMin : -1;
//     }