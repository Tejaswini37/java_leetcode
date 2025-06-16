class Solution {
    public void bt(int start,int c,int k,int n,ArrayList<Integer> t,List<List<Integer>> ans){
        if(c==k && n==0){
            ans.add(new ArrayList<>(t));
            return;
        }
        if(c==k || n<0) return;
        for(int i=start;i<=9;i++){
            t.add(i);
            bt(i+1,c+1,k,n-i,t,ans);
            t.remove(t.size()-1);
        }

    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        bt(1,0,k,n,new ArrayList<>(),ans);
        return ans;
    }
}