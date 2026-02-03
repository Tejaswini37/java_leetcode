class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minabs=Integer.MAX_VALUE,n=arr.length;
        for(int i=0;i<n-1;i++){
            minabs=Math.min(minabs,arr[i+1]-arr[i]);
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n-1;i++){
            if(arr[i+1]-arr[i]==minabs) 
            ans.add(Arrays.asList(arr[i],arr[i+1]));
        }
        return ans;
    }
}