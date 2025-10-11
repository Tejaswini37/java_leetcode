// class Solution {
//     public int firstUniqChar(String s) {
//         HashMap<Character,Integer> hm=new HashMap<>();
//         // for(int i=0;i<s.length();i++){
//         //     char ch=s.charAt(i);
//         //     if(hm.containsKey(ch)) hm.put(ch,-1);
//         //     else hm.put(ch,i);
//         // }
//         // for(int i=0;i<s.length();i++){
//         //     if(hm.get(s.charAt(i))!=-1) return hm.get(s.charAt(i));
//         // }
//         for(char c: s.toCharArray()) hm.put(c,hm.getOrDefault(c,0)+1);
//         for(int i=0;i<s.length();i++){
//             if(hm.get(s.charAt(i))==1) return i;
//         }
//         return -1;
//     }
// }

class Solution {
    public int firstUniqChar(String s) {
        if(s.length() == 0)  return -1;
        int[] store = new int[26];
        for(char ch : s.toCharArray()){
            store[ch - 'a']++;    
        }
        
        for(int idx = 0; idx < s.length(); idx++){
            if(store[s.charAt(idx) - 'a'] == 1){
                return idx;
            }
        }
        return -1;      // if no character appeared exactly once...
    }
}