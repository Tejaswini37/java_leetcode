class Solution {
    public int sumByD(int a[],int k){
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=Math.ceil((double)(a[i])/(double)(k));
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int l=1, h=nums[0];
        for(int i=0;i<n;i++) h=Math.max(h,nums[i]);
        while(l<=h){
            int mid=(l+h)/2;
            if( sumByD(nums, mid)<=threshold){
                h=mid-1;
            }
            else l=mid+1;
        }
        return l;
        
    }
}