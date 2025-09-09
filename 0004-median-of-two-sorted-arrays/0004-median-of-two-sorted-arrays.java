class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m=nums1.length, n=nums2.length;
        int left=0, right=m; //0 -> no elements taken from nums1 m->all
        int size=(m+n+1)/2;
        while(left<=right){
            int mid=(left+right)/2;
            int n1=mid; // LEFT SIZE OF num1
            int n2=size-mid;

            int l1=(n1>0)?nums1[n1-1]:Integer.MIN_VALUE;
            int l2=(n2>0)?nums2[n2-1]:Integer.MIN_VALUE;

            int r1=(n1<m)?nums1[n1]:Integer.MAX_VALUE;
            int r2=(n2<n)?nums2[n2]:Integer.MAX_VALUE;
            
            if(l1<=r2 && l2<=r1){
                if((n+m)%2==0){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/(2.0);
                }
                return Math.max(l1,l2);
            }
            else if(l1>r2) right=mid-1;
            else left=mid+1;


        }
        return 0.0;
    }
}
// The simplest way is to merge both arrays into one sorted array, then directly pick the middle element(s).

//optimal
// Always binary search on the smaller array (nums1).

// Partition index i in nums1, partition index j = (m+n+1)/2 - i in nums2.

// Check if partition is valid:

// nums1[i-1] <= nums2[j] and nums2[j-1] <= nums1[i].

// If not valid, adjust i using binary search.

// Once valid, compute median from max(left partition), min(right partition).

// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         // Ensure nums1 is the smaller array (to binary search on it)
//         if (nums1.length > nums2.length) {
//             return findMedianSortedArrays(nums2, nums1);
//         }

//         int m = nums1.length;
//         int n = nums2.length;

//         int low = 0, high = m;
//         int totalLeft = (m + n + 1) / 2; // size of left partition

//         while (low <= high) {
//             int cut1 = (low + high) / 2;       // elements taken from nums1
//             int cut2 = totalLeft - cut1;       // elements taken from nums2

//             // Left and right values around the cut
//             int left1  = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
//             int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];
//             int left2  = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
//             int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

//             // Check if partition is valid
//             if (left1 <= right2 && left2 <= right1) {
//                 if ((m + n) % 2 == 0) {
//                     return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
//                 } else {
//                     return Math.max(left1, left2);
//                 }
//             } else if (left1 > right2) {
//                 high = cut1 - 1; // move left
//             } else {
//                 low = cut1 + 1;  // move right
//             }
//         }
//         return 0.0; // should never reach here
//     }
// }


// cut1 → how many elements taken from nums1 into the left partition

// cut2 → how many elements taken from nums2 into the left partition

// left1 → last element on the left side of nums1 partition

// right1 → first element on the right side of nums1 partition

// left2 → last element on the left side of nums2 partition

// right2 → first element on the right side of nums2 partition