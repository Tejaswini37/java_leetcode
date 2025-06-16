class Solution {
    public static boolean bt(int i,String s, List<String> d,Map<Integer,Boolean> mp){
        if(i==s.length()) return true;
        if(mp.containsKey(i)) return mp.get(i);
        for(int start=i+1;start<=s.length();start++){
            String part=s.substring(i,start);
            if(d.contains(part)){
                if(bt(start,s,d,mp)){
                    mp.put(i,true);
                    return true;
                }
            }
        }
        mp.put(i,false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer,Boolean> mp=new HashMap<>();
        return bt(0,s,wordDict,mp);
    }
}