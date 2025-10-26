class Solution {
    public boolean dfs(int start, int v,int graph[][], int color[],int c){
        color[start]=c;
        for(int i=0;i<graph[start].length;i++){
            int vertex=graph[start][i];
            if(color[vertex]==-1){
                if(dfs(vertex,v,graph,color,1-c)==false) return false;
            }
            else if(color[vertex]==c) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int v=graph.length;
        int color[]=new int[v];
        for(int i=0;i<v;i++) color[i]=-1;
        for(int i=0;i<v;i++){
            if(color[i]==-1) {
                if(dfs(i,v,graph,color,0)==false) return false;
            }
        }
        return true;
    }
}

// bfs
// boolean check(int start,int v, LL adj, int color[]){
//     Queue<Integer> q=new LinkedList<Integer>();
//     q.add(start);
//     color[start]=0;
//     while(!q.isEmpty()){
//         int node=q.poll();
//         for(int x: adj.get(node)){
//             if(color[x]==-1){
//                 color[x]=1-color[node];
//                 q.add(x);
//             }
//             else if(color[x]==color[node]){
//                 return false;
//             }
//         }
//     }
//     return true;
// }