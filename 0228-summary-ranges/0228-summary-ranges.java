class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        if(nums.length==0) return ans;
        int start=0,end=1;
        while(end<nums.length){
            if(nums[end]!=nums[end-1]+1){
                if(start!=end-1)
                ans.add(nums[start]+"->"+nums[end-1]);
                else ans.add(nums[start]+"");
                start=end;
            }
            end++;
        }
        if(start!=end-1)
        ans.add(nums[start]+"->"+nums[end-1]);
        else ans.add(nums[start]+"");
        return ans;
    }
}