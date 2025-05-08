class Solution {
    public int trap(int[] height) {
        int leftMax=0,rightMax=0,res=0;
        int l=0,r=height.length-1;
        while(l<r){
            leftMax=Math.max(leftMax,height[l]);
            rightMax=Math.max(rightMax,height[r]);
            res+=leftMax>rightMax?rightMax-height[r--]:leftMax-height[l++];
            
        }
        return res;
    }
}
// // Approach 1: Precompute Left and Right Max Arrays (O(N) Time, O(N) Space)
// class Solution {
//     public int trap(int[] arr) {
//         int n = arr.length;
//         int[] lmax = new int[n];
//         lmax[0] = arr[0];
//         for (int i = 1; i < n; i++) 
//             lmax[i] = Math.max(lmax[i - 1], arr[i]);
        
//         int[] rmax = new int[n];
//         rmax[n - 1] = arr[n - 1];
//         for (int i = n - 2; i >= 0; i--) 
//             rmax[i] = Math.max(rmax[i + 1], arr[i]);

//         int ans = 0;
//         for (int i = 0; i < n; i++) 
//             ans += Math.min(lmax[i], rmax[i]) - arr[i];

//         return ans;
//     }
// }
// class Solution {
//     public int trap(int[] height) {
//         int leftMax=0,rightMax=0,res=0;
//         int l=0,r=height.length-1;
//         while(l<r){
//             if(height[l]<=height[r]){
//                 if(leftMax>height[l]) res+=leftMax-height[l];
//                 else leftMax=height[l];
//                 l++;
//             }
//             else{
//                 if(rightMax>height[r]) res+=rightMax-height[r];
//                 else rightMax=height[r];
//                 r--;
//             }
//         }
//         return res;
//     }
// }