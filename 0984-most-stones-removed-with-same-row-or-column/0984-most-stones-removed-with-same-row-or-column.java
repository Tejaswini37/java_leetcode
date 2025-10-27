class Solution {
    class DSU{
        int parent[];
        DSU(int n){
            parent=new int[n];
            for(int i=0;i<n;i++) parent[i]=i;
        }
        int find(int x){
            if(parent[x]!=x)
                parent[x]=find(parent[x]);
            return parent[x];
        }
        void union(int a,int b){
            int pa=find(a);
            int pb=find(b);
            if(pa!=pb) parent[pa]=pb;
        }
    }
    public int removeStones(int[][] stones) {
        // To avoid collision between x and y indices, offset y by a constant (like 10000).
        DSU dsu=new DSU(20002);  //enough for both x and y
        for(int s[]: stones){
            dsu.union(s[0],s[1]+10001); // offset y to separate space
        }
        Set<Integer> unique=new HashSet<>();
        for(int s[]: stones){
            unique.add(dsu.find(s[0]));
            unique.add(dsu.find(s[1]+10001)); // ✅ offset y here as well
        }
        return stones.length-unique.size();
    }
}

//  DFS
// class Solution {
//     public int removeStones(int[][] stones) {
//         int n = stones.length;
//         boolean[] visited = new boolean[n];
//         int components = 0;

//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 dfs(stones, i, visited);
//                 components++;
//             }
//         }

//         // Stones removed = total stones - number of components
//         return n - components;
//     }

//     private void dfs(int[][] stones, int i, boolean[] visited) {
//         visited[i] = true;
//         for (int j = 0; j < stones.length; j++) {
//             if (!visited[j] && (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1])) {
//                 dfs(stones, j, visited);
//             }
//         }
//     }
// }
