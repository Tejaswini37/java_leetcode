class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int pairs[][]=new int[n][2];
        for(int i=0;i<n;i++){
            pairs[i][0]=nums2[i];
            pairs[i][1]=nums1[i];
        }
        // Sort by nums2 descending
        Arrays.sort(pairs,(a,b)->b[0]-a[0]);
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        long sum=0,res=0;
        for(int p[]:pairs){
            int n2=p[0];
            int n1=p[1];
            minHeap.offer(n1);
            sum+=n1;
            // Only keep k elements
            if(minHeap.size()>k){
                sum-=minHeap.poll();
            }
            // If we have k elements, update result
            if(minHeap.size()==k){
                res=Math.max(res,sum*n2);
            }

        }
        return res;
    }
}
// Create pairs (nums2[i], nums1[i]).

// Sort pairs by nums2 descending.

// Traverse pairs:

// Add nums1[i] into a min-heap.

// Keep track of their sum.

// If heap size > k → pop the smallest nums1 (we only need the top k).

// If heap size == k → compute score = sum(nums1 in heap) * current nums2.

// Update max score.