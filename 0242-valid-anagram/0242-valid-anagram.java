class Solution {
    public boolean isAnagram(String s, String t) {
        int c[]=new int[26];
        for(char x: s.toCharArray()) c[x-'a']++;
        for(char x: t.toCharArray()) c[x-'a']--;
        for(int x: c) if(x!=0) return false;
        return true;
    }
}

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) return false;
//         char[] sArr = s.toCharArray();
//         char[] tArr = t.toCharArray();
//         Arrays.sort(sArr);
//         Arrays.sort(tArr);
//         return Arrays.equals(sArr, tArr);
//     }
// }

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) return false;

//         int[] count = new int[26]; // only lowercase letters

//         for (char c : s.toCharArray()) {
//             count[c - 'a']++;
//         }

//         for (char c : t.toCharArray()) {
//             count[c - 'a']--;
//         }

//         for (int val : count) {
//             if (val != 0) return false;
//         }
//         return true;
//     }
// }

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) return false;

//         Map<Character, Integer> map = new HashMap<>();

//         for (char c : s.toCharArray()) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }

//         for (char c : t.toCharArray()) {
//             if (!map.containsKey(c)) return false;
//             map.put(c, map.get(c) - 1);
//             if (map.get(c) == 0) map.remove(c);
//         }

//         return map.isEmpty();
//     }
// }
