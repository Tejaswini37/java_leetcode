class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans=0;
        int c=0,l=0;
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
        }
        for(int r=0;r<n;r++){
            if(nums[r]==max) c++;
            while(c>=k){
                if(nums[l]==max) c--;
                l++;
            }
            ans+=l;
        }
        return ans;
    }
}
// public int countSubarrays(int[] nums, int k) {
//     int cnt = 0, ans = 0;
//     int maxN = Arrays.stream(nums).max().getAsInt();
//     int left = 0, n = nums.length;

//     for (int right = 0; right < n; right++) {
//         if (nums[right] == maxN) cnt++;
//         while (cnt >= k) {
//             ans += n - right;
//             if (nums[left] == maxN) cnt--;
//             left++;
//         }
//     }
//     return ans;
// }