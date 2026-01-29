class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long INF=Long.MAX_VALUE/2;
        long dist[][]=new long[26][26];
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j) dist[i][j]=0;
                else dist[i][j]=INF;
            }
        }
        // given connections
        for(int i=0;i<original.length;i++){
            int u=original[i]-'a';
            int v=changed[i]-'a';
            dist[u][v]=Math.min(dist[u][v],cost[i]);
        }
        // floyd warshall
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                for(int j=0;j<26;j++){
                    if(dist[i][k]+dist[k][j]<dist[i][j]){
                        dist[i][j]=dist[i][k]+dist[k][j];
                    }
                }
            }
        }
        // cost
        long ans=0;
        for(int i=0;i<source.length();i++){
            int u=source.charAt(i)-'a';
            int v=target.charAt(i)-'a';
            if(dist[u][v]==INF) return -1;
            ans+=dist[u][v];
        }
        return ans;
    }
}
