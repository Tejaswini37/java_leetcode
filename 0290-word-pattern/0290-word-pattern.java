class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[]=s.split(" ");
        if(words.length!=pattern.length()) return false;
        Map<Character,String> hm=new HashMap<>();
        for(int i=0;i<words.length;i++){
            if(hm.containsKey(pattern.charAt(i))){
                if(!hm.get(pattern.charAt(i)).equals(words[i]))
                return false;
            }
            else if(hm.containsValue(words[i])) return false;
            else hm.put(pattern.charAt(i),words[i]);
        }
        return true;
    }
}
// public boolean wordPattern(String pattern, String str) {
//     String[] words = str.split(" ");
//     if (words.length != pattern.length())
//         return false;
//     Map index = new HashMap();
//     for (Integer i=0; i<words.length; ++i)
//         if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
//             return false;
//     return true;
// }

// class Solution {
//     public boolean wordPattern(String pattern, String s) {
        
//         String [] arr=s.split(" ");
//         int slen=arr.length;
//         int plen=pattern.length();
//         if(plen != slen)return false;
//         Map<Character,String>map=new HashMap<>();
//         int i=-1;
//          char [] arr2=pattern.toCharArray();
//         for(Character ch :arr2){
//              i++;
//             if(map.containsKey(ch)){
//              if(!map.get(ch).equals(arr[i]))return false;
//             }
//             else if(map.containsValue(arr[i])){
//                 return false;

//             }
//             else{
//             map.put(ch,arr[i]);
           
//         }
//         //System.out.print(i+" ");
//        }
//         return true;

//     }
// }