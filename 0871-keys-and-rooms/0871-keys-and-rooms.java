class Solution {
    public void dfs(List<List<Integer>> rooms,boolean vis[],int room){
        if(vis[room]) return;
        vis[room]=true;
        for(int key: rooms.get(room)){
            dfs(rooms,vis,key);
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[]=new boolean[rooms.size()];
        dfs(rooms,vis,0);
        for(boolean v: vis){
            if(!v) return false;
        }
        return true;
    }
}