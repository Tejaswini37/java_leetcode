// class Solution {
// //     Sorting takes O(n log n).
// //     But we don’t need the fully sorted array — only one element (kth largest).
// // \U0001f449 Quickselect can find it in O(n) average time.
// // if n=6, k=2 → target = 6-2=4.
// // We must find 4th index element in sorted order.
//     public void swap(int nums[],int i,int j){
//         int t=nums[i];
//         nums[i]=nums[j];
//         nums[j]=t;
//     }
//     public int partition(int nums[], int left, int right){
//         int storeIndex=left;
//         int pivot=nums[right];
//         for(int i=left;i<right;i++){
//             if(nums[i]<=pivot){
//                 swap(nums,storeIndex,i);
//                 storeIndex++;
//             }
//         }
//         swap(nums,storeIndex,right);
//         return storeIndex;
//     }
//     public int findKthLargest(int[] nums, int k) {
//         int n=nums.length;
//         int target=n-k;
        
//         int left=0, right=n-1;
//         while(left<=right){
//             int pivotIndex=partition(nums,left,right);
//             if(pivotIndex==target) {
//                 return nums[pivotIndex];
//             }
//             else if(pivotIndex < target){
//                 left=pivotIndex+1;
//             }
//             else right=pivotIndex-1;
//         }
//         return -1;
//     }
// }
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        Random rand = new Random();
        while (true) {
            int pivot_index = left + rand.nextInt(right - left + 1);
            int new_pivot_index = partition(nums, left, right, pivot_index);
            if (new_pivot_index == nums.length - k) {
                return nums[new_pivot_index];
            } else if (new_pivot_index > nums.length - k) {
                right = new_pivot_index - 1;
            } else {
                left = new_pivot_index + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right, int pivot_index) {
        int pivot = nums[pivot_index];
        swap(nums, pivot_index, right);
        int stored_index = left;
        for (int i = left; i < right; i++) {
            if (nums[i] < pivot) {
                swap(nums, i, stored_index);
                stored_index++;
            }
        }
        swap(nums, right, stored_index);
        return stored_index;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// 1.sort

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();

//         for (int num : nums) {
//             minHeap.add(num);
//             if (minHeap.size() > k) {
//                 minHeap.poll();
//             }
//         }

//         return minHeap.peek();        
//     }
// }


// using binary search
// public static int kthElement(ArrayList<Integer> a, ArrayList<Integer> b, int m, int n, int k) {
//         if (m > n) return kthElement(b, a, n, m, k);

//         int left = k; // length of left half

//         // apply binary search:
//         int low = Math.max(0, k - n), high = Math.min(k, m);
//         while (low <= high) {
//             int mid1 = (low + high) >> 1;
//             int mid2 = left - mid1;
//             // calculate l1, l2, r1, and r2
//             int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
//             int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
//             if (mid1 < m) r1 = a.get(mid1);
//             if (mid2 < n) r2 = b.get(mid2);
//             if (mid1 - 1 >= 0) l1 = a.get(mid1 - 1);
//             if (mid2 - 1 >= 0) l2 = b.get(mid2 - 1);

//             if (l1 <= r2 && l2 <= r1) {
//                 return Math.max(l1, l2);
//             }

//             // eliminate the halves:
//             else if (l1 > r2) high = mid1 - 1;
//             else low = mid1 + 1;
//         }
//         return 0; // dummy statement
//     }
