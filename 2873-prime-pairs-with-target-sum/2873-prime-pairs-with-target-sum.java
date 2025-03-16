class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        boolean p[]=new boolean[n+1];
        Arrays.fill(p,true);
        for(int i=2;i*i<=n;i++){
            if(p[i]==true){
                for(int j=i*i;j<=n;j+=i){
                    p[j]=false;
                }
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=2;i<n/2+1;i++){
            if(p[i] && p[n-i]) ans.add(Arrays.asList(i,n-i));
        }
        return ans;


    }
}