class Solution {
    int timer=1;
    public void dfs(int node,int parent,ArrayList<ArrayList<Integer>> adj,List<List<Integer>> bridges,int tin[],int low[],int vis[]){
        vis[node]=1;
        tin[node]=low[node]=timer++;
        for(int it : adj.get(node)){
            if(it==parent) continue;
            if(vis[it]==0){
                dfs(it,node,adj,bridges,tin,low,vis);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>tin[node]){
                    bridges.add(Arrays.asList(it,node));
                }
            }
            else{
                low[node]=Math.min(low[node],low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> it: connections){
            int u=it.get(0), v=it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[]=new int[n];
        int low[]=new int[n];
        int tin[]=new int[n];
        List<List<Integer>> bridges=new ArrayList<>();
        dfs(0,-1,adj,bridges,tin,low,vis);
        return bridges;
    }
}