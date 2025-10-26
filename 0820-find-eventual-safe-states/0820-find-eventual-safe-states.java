// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
        
//     }
// }

// terminal node -> no outgoing edges
// safe node is a node that follows a path and that leads to terminal node
// node that is not part of cycle == safe node

// We detect cycles using DFS + recursion stack:
// vis[i] = 1 → node is visited.
// pathVis[i] = 1 → node is currently in recursion stack.
// If during DFS, we visit a node already in pathVis, we found a cycle.
// If a node doesn’t lead to a cycle, mark it as safe (check[i] = 1).
// Finally, return all nodes where check[i] == 1.

class Solution {
    public boolean dfs(int node, int graph[][],int vis[],int pathvis[],int check[]){
        vis[node]=1;
        pathvis[node]=1;
        for(int x: graph[node]){
            if(vis[x]==0){
                if(dfs(x,graph,vis,pathvis,check)){
                    check[node]=0;
                    return true;
                }
            }
            else if(pathvis[x]==1){
                check[node]=0;
                return true;
            }
        }
        pathvis[node]=0;
        check[node]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        int vis[]=new int[n];
        int pathvis[]=new int[n];
        int check[]=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,pathvis,check);
            }
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1) ans.add(i);
        }
        return ans;
    }
}