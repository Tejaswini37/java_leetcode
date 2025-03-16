class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<>();
        int n=nums.length;
        List<Integer> res=new ArrayList<>();
        for(int x:nums){
            h.put(x,h.getOrDefault(x,0)+1);
            if(h.get(x)>(n/3) && !res.contains(x)) res.add(x);
        }
        return res;
    }
}