class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        int p[]=new int[n+1];
        
        for(int i=2;i*i<=n;i++){
            if(p[i]==0){
                for(int j=i*i;j<=n;j+=i){
                    p[j]=1;
                }
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=2;i<n/2+1;i++){
            if(p[i]==0 && p[n-i]==0) ans.add(Arrays.asList(i,n-i));
        }
        return ans;


    }
}