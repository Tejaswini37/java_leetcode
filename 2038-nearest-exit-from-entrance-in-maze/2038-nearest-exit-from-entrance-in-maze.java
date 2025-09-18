class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows=maze.length;
        int cols=maze[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{entrance[0],entrance[1],0});
        int[][] dirs={{-1,0},{1,0},{0,1},{0,-1}};
        //mark entrance visited
        maze[entrance[0]][entrance[1]]='+';
        while(!q.isEmpty()){
            int cur[]=q.poll();
            int r=cur[0], c=cur[1], steps=cur[2];
            for( int d[]: dirs){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr<0 || nc<0 || nr>=rows || nc>=cols) continue;
                if(maze[nr][nc]=='.'){
                    if(nr==0 || nc==0 || nr==rows-1 || nc==cols-1) return steps+1;
                    //mark visited
                    maze[nr][nc]='+';
                    q.add(new int[]{nr,nc,steps+1});
                }

            }
        }
        return -1;
    }
}