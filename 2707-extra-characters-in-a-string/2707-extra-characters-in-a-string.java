class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        HashSet<String> hs=new HashSet<>();
        for(String x: dictionary) hs.add(x);
        int memo[]=new int[s.length()];
        Arrays.fill(memo,-1);
        return dfs(s,0,hs,memo);
    }
    public int dfs(String s,int idx,HashSet<String> hs,int memo[]){
        if(idx==s.length()) return 0;
        if(memo[idx]!=-1) return memo[idx];
        // option 1 : skip current character
        int ans=1+dfs(s,idx+1,hs,memo);
        for(int end=idx; end<s.length(); end++){
            String sub=s.substring(idx,end+1);
            if(hs.contains(sub)){
                ans=Math.min(ans,dfs(s,end+1,hs,memo));
            }
        }
        memo[idx]=ans;
        return ans;
    }
}