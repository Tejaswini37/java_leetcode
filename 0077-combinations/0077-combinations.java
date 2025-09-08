class Solution {
    public void bt(int n, int k,int idx,ArrayList<Integer> temp, List<List<Integer>> res){
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        // Pruning (Optimization)
        // We can stop early if remaining numbers are not enough to fill k.
        // for(int start=idx;start<=n;start++){
        for(int start=idx; start<= n-(k-temp.size())+1; start++){
            temp.add(start);
            bt(n,k,start+1,temp,res);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        bt(n,k,1,new ArrayList<>(),res);
        return res;
    }
}