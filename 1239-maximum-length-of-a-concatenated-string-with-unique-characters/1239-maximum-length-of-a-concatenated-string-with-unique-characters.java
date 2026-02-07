class Solution {
    int max=0;
    public int maxLength(List<String> arr) {
        bt(arr,0,new HashSet<>());
        return max;
    }
    void bt(List<String> arr,int idx,Set<Character> used){
        max=Math.max(max,used.size());
        for(int i=idx;i<arr.size();i++){
            String s=arr.get(i);
            if(!canAdd(s,used)) continue;
            // take
            for(char c : s.toCharArray()) used.add(c);

            bt(arr,i+1,used);

            // not take
            for(char c:s.toCharArray()) used.remove(c);

        }
    }
    boolean canAdd(String s,Set<Character> used){
        Set<Character> temp=new HashSet<>();
        for(char c : s.toCharArray()){
            if(temp.contains(c) || used.contains(c)) return false;
            temp.add(c);
        }
        return true;
    }
}
