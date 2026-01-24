class Solution {
    public int findMaxLength(int[] nums) {
        int ans=0,sum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        // prefix sum 0 at index -1
        hm.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum+=(nums[i]==0)?-1:1;
            if(hm.containsKey(sum)){
                ans=Math.max(ans,i-hm.get(sum));
            }
            else hm.put(sum,i);
        }
        
        return ans;
    }
}