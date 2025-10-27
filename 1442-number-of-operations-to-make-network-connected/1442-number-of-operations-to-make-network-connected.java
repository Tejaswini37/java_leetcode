class Solution {
    private int find(int parent[],int x){
        if(parent[x]!=x)
            parent[x]=find(parent,parent[x]);
        return parent[x];
    }
    private void union(int parent[],int rank[],int x,int y){
        int px=find(parent,x);
        int py=find(parent,y);
        if(px==py) return;
        if(rank[px]<rank[py]) parent[px]=py;
        else if(rank[py]<rank[px]) parent[py]=px;
        else{
            parent[py]=px;
            rank[px]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1) return -1;
        int parent[]=new int[n];
        int rank[]=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int e[]:connections){
            union(parent,rank,e[0],e[1]);
        }
        // Set<Integer> st=new HashSet<>();
        // for(int i=0;i<n;i++){
        //     st.add(find(parent,i));
        // }
        // return st.size()-1;
        // Count unique components
        int components = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) components++;
        }

        // To connect all components, we need (components - 1) operations
        return components - 1;
    }
}