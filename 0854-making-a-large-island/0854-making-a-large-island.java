class DSU{
    List<Integer> rank=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DSU(int n){
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    public int find(int node){
        if(parent.get(node)!=node){
            int ulp=find(parent.get(node));
            parent.set(node,ulp);
        }
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int ulp_u=find(u);
        int ulp_v=find(v);
        if(ulp_u==ulp_v) return;
        if(rank.get(ulp_u)<rank.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
        }
        else if(rank.get(ulp_v)<rank.get(ulp_u)){
            parent.set(ulp_v,ulp_u);
        }
        else{
            parent.set(ulp_v,ulp_u);
            int r=rank.get(ulp_u);
            rank.set(ulp_u, r+1);
        }
    }
    public void unionBySize(int u, int v) {
        int ulp_u = find(u);
        int ulp_v = find(v);
        if (ulp_u == ulp_v) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    private boolean isValid(int r,int c,int n){
        return r>=0 && r<n && c>=0 && c<n;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DSU dsu=new DSU(n*n);
        // step 1
        for(int row=0; row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0) continue;
                int dr[]={-1,0,1,0};
                int dc[]={0,-1,0,1};
                for(int i=0;i<4;i++){
                    int nr=row+dr[i];
                    int nc=col+dc[i];
                    if(isValid(nr,nc,n) && grid[nr][nc]==1){
                        int nodeno=row*n+col; // node number
                        int adjno=nr*n+nc;
                        dsu.unionBySize(nodeno,adjno);
                    }
                }
            }
        }
        // step 2
        int mx=0;
        for(int row=0; row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1) continue;
                int dr[]={-1,0,1,0};
                int dc[]={0,-1,0,1};
                HashSet<Integer> components=new HashSet<>();
                for(int i=0;i<4;i++){
                    int nr=row+dr[i];
                    int nc=col+dc[i];
                    if(isValid(nr,nc,n)){
                        if(grid[nr][nc]==1){
                            components.add(dsu.find(nr*n+nc));
                        }
                    }
                }
                int sizeTotal=0;
                for(Integer parents: components){
                    sizeTotal+=dsu.size.get(parents);
                }
                mx=Math.max(mx,sizeTotal+1);
            }
        }
        for(int cellNo=0; cellNo<n*n; cellNo++){
            mx=Math.max(mx, dsu.size.get(dsu.find(cellNo)));
        }
        return mx;
    }
}