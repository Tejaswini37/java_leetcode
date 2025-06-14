class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int hash[]=new int[n];
        for(int i=0;i<n;i++) hash[i]=i;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int lastindex=0;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(nums[i]%nums[prev]==0 && dp[prev]>=dp[i]){
                    hash[i]=prev;
                    dp[i]=dp[prev]+1;
                }
            }
            if(dp[i]>dp[lastindex]) lastindex=i;
        }
        ArrayList<Integer> a=new ArrayList<>();
        while(hash[lastindex]!=lastindex){
            a.add(nums[lastindex]);
            lastindex=hash[lastindex];
        }
        a.add(nums[lastindex]);
        Collections.reverse(a);
        return a;
    }
}