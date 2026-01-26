class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n-k+1];
        int len=1;
        ans[0]=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1) len++;
            else len=1;
            if(i>=k-1){
                if(len>=k) ans[i-k+1]=nums[i];
                else ans[i-k+1]=-1;
            }
        }
        return ans;
    }
}
