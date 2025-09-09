class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        // initialize minheap with first element of nums2 witl all elements of nums1;
        for(int i=0;i<Math.min(nums1.length,k);i++){
            pq.add(new int[]{nums1[i]+nums2[0],i,0});
        }
        while(k>0 && !pq.isEmpty()){
            int cur[]=pq.poll();
            int i=cur[1],  j=cur[2];
            res.add(Arrays.asList(nums1[i],nums2[j]));
            k--;
            if(j+1<nums2.length){
                pq.add(new int[]{nums1[i]+nums2[j+1],i,j+1});
            }
        }
        return res;
    }
}