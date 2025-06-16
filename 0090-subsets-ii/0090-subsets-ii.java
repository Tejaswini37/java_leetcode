class Solution {
    public void bt(int i,int a[],ArrayList<Integer> t,List<List<Integer>> ans){
        ans.add(new ArrayList<>(t));
        for(int j=i;j<a.length;j++){
            if(j>i && a[j]==a[j-1]) continue;
            t.add(a[j]);
            bt(j+1,a,t,ans);
            t.remove(t.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        bt(0,nums,new ArrayList<>(),ans);
        return ans;
    }
}