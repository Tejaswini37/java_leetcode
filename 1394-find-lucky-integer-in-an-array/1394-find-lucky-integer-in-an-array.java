class Solution {
    public int findLucky(int[] arr) {
        int lucky=-1;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int x=arr[i];
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        for(int x: hm.keySet()){
            if(x==hm.get(x) && lucky<x) lucky=x;
        }
        return lucky;
    }
}