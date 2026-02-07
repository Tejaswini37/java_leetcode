class Solution {
    int sum=0;
    public void dfs(int nums[],int i,int curxor){
        if(i==nums.length) {
            sum+=curxor;
            return;
        }
        dfs(nums,i+1,curxor^nums[i]); //include
        dfs(nums,i+1,curxor);
    }
    public int subsetXORSum(int[] nums) {
        dfs(nums,0,0);
        return sum;
    }
}
// Time: O(2^n)
// Space: O(n) (recursion stack