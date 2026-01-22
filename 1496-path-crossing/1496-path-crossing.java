class Solution {
    public boolean isPathCrossing(String path) {
        int x=0,y=0;
        HashSet<String> hs=new HashSet<>();
        hs.add("0,0");
        for(char c : path.toCharArray()){
            if(c=='N') y++;
            else if(c=='S') y--;
            else if(c=='E') x++;
            else x--;
            String pos=x+","+y;
            if(hs.contains(pos)) return true;
            hs.add(pos);
        }
        return false;
    }
}