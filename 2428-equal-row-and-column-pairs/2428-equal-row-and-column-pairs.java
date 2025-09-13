class Solution {
    public int equalPairs(int[][] grid) {
        int n=grid.length;
        Map<String,Integer> hm=new HashMap<>();
        //store rows
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(grid[i][j]).append(",");
            }
            hm.put(sb.toString(),hm.getOrDefault(sb.toString(),0)+1);
        }

        int count=0;
        // chaeck columns
        for(int i=0;i<n;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                sb.append(grid[j][i]).append(",");
            }
            count+=hm.getOrDefault(sb.toString(),0);
        }
        return count;
    }
}