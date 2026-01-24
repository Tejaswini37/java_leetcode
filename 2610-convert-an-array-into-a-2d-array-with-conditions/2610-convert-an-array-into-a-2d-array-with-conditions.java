class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int maxfreq=0;  //number of rows
        for(int n : nums){
            hm.put(n,hm.getOrDefault(n,0)+1);
            maxfreq=Math.max(maxfreq,hm.get(n));
        }
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<maxfreq;i++){
            res.add(new ArrayList<>());
        }
        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            int num=entry.getKey();
            int count=entry.getValue();
            for(int i=0;i<count;i++){
                res.get(i).add(num);
            }
        }
        return res;
    }
}
