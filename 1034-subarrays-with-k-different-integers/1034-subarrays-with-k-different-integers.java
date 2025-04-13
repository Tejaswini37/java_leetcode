class Solution {
    public static int atmost(int nums[],int k){
        int ans=0;
        int n=nums.length;
        int l=0;
        int cnt=0;
        int c[]=new int[n+1];
        for(int r=0;r<n;r++){
            c[nums[r]]++;
            if(c[nums[r]]==1) cnt++;
            
            while(cnt>k){
                
                c[nums[l]]--;
                if(c[nums[l]]==0) cnt--;
                l++;
            }
            ans+=(r-l+1);
        }
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return atmost(nums,k)-atmost(nums,k-1);
    }
}