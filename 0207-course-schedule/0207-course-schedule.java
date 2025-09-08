class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> al=new ArrayList<>();
        for(int i=0;i<numCourses;i++) al.add(new ArrayList<>());
        int indegree[]=new int[numCourses];
        int c=0;
        for(int i=0;i<prerequisites.length;i++){
            al.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int node=q.poll();
            c++;
            for(int x: al.get(node)){
                indegree[x]--;
                if(indegree[x]==0) q.add(x);
            }
        }
        return c==numCourses;
    }
}

// dfs cycle detection
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < numCourses; i++) {
//             adj.add(new ArrayList<>());
//         }
//         for (int[] pre : prerequisites) {
//             adj.get(pre[1]).add(pre[0]);
//         }

//         boolean[] visited = new boolean[numCourses];
//         boolean[] path = new boolean[numCourses];

//         for (int i = 0; i < numCourses; i++) {
//             if (!visited[i]) {
//                 if (dfs(i, adj, visited, path)) return false;
//             }
//         }
//         return true;
//     }

//     private boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] path) {
//         if (path[node]) return true;  // cycle found
//         if (visited[node]) return false; // already processed safely

//         path[node] = true;   // mark in current recursion stack
//         for (int nei : adj.get(node)) {
//             if (dfs(nei, adj, visited, path)) return true;
//         }
//         path[node] = false;  // backtrack
//         visited[node] = true; // mark as fully checked
//         return false;
//     }
// }
