class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer>q=new ArrayDeque<>();
        int res[]=new int[nums.length-k+1];
        for(int i=0;i<k;i++) {
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]) q.pollLast();
            q.add(i);
        }
        res[0]=nums[q.peekFirst()];
        for(int i=k;i<nums.length;i++){
            if(!q.isEmpty() && i-q.peekFirst()>=k) q.pollFirst();
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]) q.pollLast();
            q.add(i);
            res[i-k+1]=nums[q.peekFirst()];
        }
        return res;
    }
}