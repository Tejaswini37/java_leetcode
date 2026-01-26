class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n=nums.length;
        Deque<Integer> maxd=new ArrayDeque<>();
        Deque<Integer> mind=new ArrayDeque<>();
        int l=0,ans=0;
        for(int r=0;r<nums.length;r++){
            // decreasing seq
            while(!maxd.isEmpty() && nums[r]>maxd.peekLast()){
                maxd.pollLast();
            }
            maxd.addLast(nums[r]);
            // increasing seq
            while(!mind.isEmpty() && nums[r]<mind.peekLast()){
                mind.pollLast();
            }
            mind.addLast(nums[r]);
            while(maxd.peekFirst()-mind.peekFirst()>limit){
                if(nums[l]==maxd.peekFirst()) maxd.pollFirst();
                if(nums[l]==mind.peekFirst()) mind.pollFirst();
                l++;
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
        
    }
}
 