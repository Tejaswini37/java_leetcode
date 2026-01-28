class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int l=1,r=0;
        for(int x : quantities) r=Math.max(x,r);
        int ans=r;
        while(l<=r){
            int mid=l+(r-l)/2;
            // helper() returns stores needed, not stores available.
            if(helper(quantities,mid)<=n){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    public int helper(int a[],int m){
        int count=0;
        for(int x : a){
            count+=(x+m-1)/m;  // ceil
        }
        return count;
    }
}