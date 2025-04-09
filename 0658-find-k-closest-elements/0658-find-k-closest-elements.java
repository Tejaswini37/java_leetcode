class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=0;
        int r=arr.length-1;
        while(r-l>=k){
            if(x-arr[l]<=arr[r]-x) r--;
            else l++;
        }
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=l;i<=r;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}