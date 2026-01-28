class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n=nums.length;
        int l=0,r=nums[n-1]-nums[0];
        int ans=r;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(canForm(nums,p,mid)){
                ans=mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ans;
    }
    private boolean canForm(int nums[],int p,int diff){
        int count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]<=diff){
                count++;
                i++; // skip paired elemnet
            }
        }
        return count>=p;
    }
}
// check if we can form p pairs with max difference <= diff
