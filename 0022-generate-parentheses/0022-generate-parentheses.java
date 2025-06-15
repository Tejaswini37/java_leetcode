class Solution {
    public void generate(int o,int c,int n,String t,List<String> ans){
        if(o==n && c==n){
            ans.add(t);
            return;
        }
        if(o<n) generate(o+1,c,n,t+"(",ans);
        if(o>c) generate(o,c+1,n,t+")",ans);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        generate(0,0,n,"",ans);
        return ans;
    }
}