class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(hm.containsKey(ch)) hm.put(ch,-1);
            else hm.put(ch,i);
        }
        for(int i=0;i<s.length();i++){
            if(hm.get(s.charAt(i))!=-1) return hm.get(s.charAt(i));
        }
        return -1;
    }
}