class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dist[][]=new int[n][n];

        // Step 1: Initialize distances
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
            dist[i][i]=0;
        }
        // Step 2: Fill in edge weights
        for(int e[] : edges){
            int u=e[0], v=e[1], w=e[2];
            dist[u][v]=w;
            dist[v][u]=w;
        }
        // Step 3: Floyd-Warshall to find all pairs shortest paths
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        // Step 4: Count reachable cities
        int ans=0,minCount=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int c=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold) c++;
            }
            if(c<=minCount) {
                minCount=c;
                ans=i;
            }
        }
        return ans;
    }
}

// We need to know the shortest distance between every pair (i, j).
// So the problem becomes a “All-Pairs Shortest Path” problem.
// For each city i, count how many cities j have dist[i][j] <= threshold.
// Track the city with the smallest count (and largest index on ties).

// a 2
// Build an adjacency list for the graph.
// Each node stores (neighbor, weight) pairs.
// For every city i:
// Run Dijkstra from i to compute the shortest distances to all other cities.
// Count how many cities are reachable within distanceThreshold.
// Keep track of:
// The minimum reachable count.
// The city with the largest index in case of ties.