class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l=1,r=0;
        for(int x : nums) r=Math.max(r,x);
        int ans=r;
        while(l<=r){
            int mid=l+(r-l)/2;
            long ops=0;
            for(int x : nums){
                ops+=(x-1)/mid;  //operations needed
            }
            if(ops<=maxOperations){
                ans=mid;
                r=mid-1; //try smaller
            }
            else l=mid+1;
        }
        return ans;
    }
}
