class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
        int ans=0,sum=0;
        for(int x:nums){
            // x=x%k;
            sum+=x;
            sum=(sum%k + k) % k; //handle negatives
            
            if(hm.containsKey(sum)) ans+=hm.get(sum);

            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}