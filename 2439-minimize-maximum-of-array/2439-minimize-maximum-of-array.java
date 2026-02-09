class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int needed=(int)((sum+i)/(i+1)); //ceil
            ans=Math.max(ans,needed);
        }
        return ans;
    }
}
// For those who are trying to understand (sum + i) / (i + 1), ceil(a / b) can be written as (a + b - 1) / b if you will put a = sum and b = i + 1 you will get the same expression.
