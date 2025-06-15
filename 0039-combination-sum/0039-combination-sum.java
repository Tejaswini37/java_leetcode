class Solution {
    public void bt(int i,int target,ArrayList<Integer> t,int[] a,List<List<Integer>> ans){
        if(i==a.length) return;
        if(target==0){
            ans.add(new ArrayList<>(t));
            return;
        }
        if(a[i]<=target){
            t.add(a[i]);
            bt(i,target-a[i],t,a,ans);
            t.remove(t.size()-1);
        }
        bt(i+1,target,t,a,ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        bt(0,target,new ArrayList<>(),candidates,ans);
        return ans;
    }
}