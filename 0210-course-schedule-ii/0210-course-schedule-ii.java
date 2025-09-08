class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int indegree[]=new int[numCourses];
        for(int pre[]: prerequisites){
            adj.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0) q.add(i);
        }
        int topo[]=new int[numCourses];
        int idx=0;
        while(!q.isEmpty()){
            int node=q.poll();
            topo[idx++]=node;
            for(int x: adj.get(node)){
                indegree[x]--;
                if(indegree[x]==0) q.add(x);
            }
        }
        if(idx!=numCourses) return new int[0];
        return topo;
    }
}

// this wont detect cycle we should use 0,1,2
// class Solution {
//     public void dfs(int node,int vis[],Stack<Integer> st,List<List<Integer>> adj){
//         vis[node]=1;
//         for(int x: adj.get(node)){
//             if(vis[x]==0) dfs(x,vis,st,adj);
//         }
//         st.push(node);
//     }
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> adj=new ArrayList<>();
//         for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
//         for(int i=0;i<prerequisites.length;i++){
//             adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
//         }
//         int vis[]=new int[numCourses];
//         Stack<Integer> st=new Stack<>();
//         for(int i=0;i<numCourses;i++){
//             if(vis[i]==0)
//             dfs(i,vis,st,adj);
//         }
//         int ans[]=new int[numCourses];
//         // if(st.size()!=numCourses) return ans;
//         // The check if (st.size()!=numCourses) is not reliable for cycle detection, because you always push nodes when DFS finishes, even if a cycle exists.
//         int i=0;
//         while(!st.isEmpty()){
//             ans[i++]=st.pop();
//         }
//         return ans;
// }
// }

// DFS with “reverse postorder” (ArrayList instead of stack)

// Instead of explicitly using a stack, you collect nodes in a list after DFS and then reverse it.
// This makes the recursion cleaner
// class Solution {
//     private boolean dfs(int node, int[] vis, List<List<Integer>> adj, List<Integer> topo) {
//         vis[node] = 1; // visiting
//         for (int nei : adj.get(node)) {
//             if (vis[nei] == 0) {
//                 if (!dfs(nei, vis, adj, topo)) return false;
//             } else if (vis[nei] == 1) {
//                 return false; // cycle
//             }
//         }
//         vis[node] = 2; 
//         topo.add(node); // add after exploring children
//         return true;
//     }

//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
//         for (int[] pre : prerequisites) {
//             adj.get(pre[1]).add(pre[0]);
//         }

//         int[] vis = new int[numCourses];
//         List<Integer> topo = new ArrayList<>();

//         for (int i = 0; i < numCourses; i++) {
//             if (vis[i] == 0) {
//                 if (!dfs(i, vis, adj, topo)) return new int[0];
//             }
//         }

//         // Reverse the list to get correct order
//         Collections.reverse(topo);

//         return topo.stream().mapToInt(Integer::intValue).toArray();
//     }
// }
