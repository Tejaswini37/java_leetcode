class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans=0, c[]=new int[101];
        for(int x : nums){
            ans+=c[x];
            c[x]++;
        }
        return ans;
    }
}

// class Solution {
//         public int numIdenticalPairs(int[] A) {
//         int ans = 0, cnt[] = new int[101];
//         for (int a: A) {
//             ans += cnt[a]++;
//         }
//         return ans;
//     }
// }