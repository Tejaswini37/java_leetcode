class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int con[]: connections){
            int from=con[0], to=con[1];
            adj.get(from).add(new int[]{to,1});
            adj.get(to).add(new int[]{from,0});
        }
        int count=0;
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[n];
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            for(int nei[]: adj.get(node)){
                int next=nei[0], cost=nei[1];
                if(!vis[next]){
                    count+=cost;
                    vis[next]=true;
                    q.add(next);
                }
            }
        }
        return count;
    }
}
// Build an adjacency list, but store the direction information:
// If edge is a → b from input:
// Store (b, 0) in adj[a] → means no change needed if we go a → b.
// Store (a, 1) in adj[b] → means if we want to go b → a, we’d need to reverse this edge.
// Do a DFS or BFS starting from node 0.
// For each neighbor (next, cost):
// cost = 1 means we need to reverse an edge.
// Add to answer.
// Continue traversal.

// Example: road [0, 1] means there’s a directed edge 0 → 1.

// We want all cities to reach city 0.
// That means if we traverse 0 → 1, it’s pointing away from 0, so this edge must be reversed if we ever use it.