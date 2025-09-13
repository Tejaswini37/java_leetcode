class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int x: arr){
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        HashSet<Integer> set=new HashSet<>();
        for(int key: hm.keySet()){
            if(set.contains(hm.get(key))) return false;
            set.add(hm.get(key));
        }
        return true;
    }
}