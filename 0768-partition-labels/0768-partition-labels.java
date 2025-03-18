class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> h=new HashMap<>();
        for(int i=0;i<s.length();i++){
            h.put(s.charAt(i),i);
        }
        int c=0;
        int max=0;
        List<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<s.length();i++){
            if(h.get(s.charAt(i))>max) max=h.get(s.charAt(i));
            if(i==max) {
                ans.add(i-c+1);
                c=i+1;
            }
            if(h.get(s.charAt(i))>max) max=h.get(s.charAt(i));

        }
        return ans;
    }
}