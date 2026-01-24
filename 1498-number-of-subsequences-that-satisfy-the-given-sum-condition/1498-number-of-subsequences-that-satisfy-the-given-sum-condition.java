class Solution {
    public int numSubseq(int[] nums, int target) {
        // understand why we are coming from bast index because if last + first is > target , last can't satisty and can't be in subsesequence because second + last is even more higher
        int mod=1_000_000_007;
        int n=nums.length;
        Arrays.sort(nums);
        // precompute power of 2
        int pow[]=new int[n];
        pow[0]=1;
        for(int i=1;i<n;i++){
            pow[i]=(pow[i-1]*2)%mod;
        }
        int l=0,r=n-1,ans=0;
        while(l<=r){
            if(nums[l]+nums[r]<=target){
                ans=(ans+pow[r-l])%mod;
                l++;
            }
            else r--;
        }
        return ans;
    }
}
// nums = [3,5,6,7]
// l = 0 (3)
// r = 2 (6)
// 3 + 6 = 9 ≤ target
// How many subsequences does this create?
// We FIX the minimum (nums[l] = 3)
// Elements between l and r: 5,6
// then subsequences= 3
// 3,5
// 3,6
// 3,5,6
// total=2^(r-l) next move l++
// we are done with min=l