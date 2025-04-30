class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String,ArrayList<String>> h=new HashMap<>();
        for(String s: strs){
            char[] s1=s.toCharArray();
            Arrays.sort(s1);
            String sortedword=new String(s1);
            if(!h.containsKey(sortedword)) h.put(sortedword,new ArrayList<>());
            h.get(sortedword).add(s);
        }
        return new ArrayList<>(h.values());
    }
}