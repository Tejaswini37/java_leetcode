class Solution {
    public List<Integer> topo(int cond[][],int k){
        List<Integer> res =new ArrayList<>();
        Map<Integer,List<Integer>> adj=new HashMap<>();
        int indegree[]=new int[k+1];
         // Build graph and in-degree array
        for(int r[] : cond){
            adj.putIfAbsent(r[0],new ArrayList<>());
            adj.get(r[0]).add(r[1]);
            indegree[r[1]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        // Add nodes with in-degree 0 (no dependencies)
        for(int i=1;i<=k;i++){
            if(indegree[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            res.add(cur);
            if (!adj.containsKey(cur)) continue;  // \U0001f525 Fix: skip if no neighbors
            for(int neigh : adj.get(cur)){
                indegree[neigh]--;
                if(indegree[neigh]==0) q.add(neigh);
            }
        }
        // If we processed all k nodes, return the valid order
        //cycle detection
        if(res.size()==k) return res;
        else return null;
    }
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Get topological orders for rows and columns
        List<Integer> rowtopo=topo(rowConditions,k);
        List<Integer> coltopo=topo(colConditions,k);
        int ans[][]=new int[k][k];
        // If either order is null, a cycle was detected, so return empty matrix
        if(rowtopo==null || coltopo==null) return new int[0][0];
         // Map each number to its row and column position
        HashMap<Integer,Integer> rowidx=new HashMap<>();
        HashMap<Integer,Integer> colidx=new HashMap<>();
        for(int i=0;i<k;i++){
            rowidx.put(rowtopo.get(i),i);
            colidx.put(coltopo.get(i),i);
        }
        // Place each number in the matrix based on its row and column position
        for(int i=1;i<=k;i++){
            int r=rowidx.get(i);
            int c=colidx.get(i);
            ans[r][c]=i;
        }
        return ans;
    }
}