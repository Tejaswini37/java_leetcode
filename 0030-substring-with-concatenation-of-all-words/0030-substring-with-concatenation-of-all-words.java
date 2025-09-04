class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        if(s==null || s.length()==0 || words.length==0) return res;
        int wordLen=words[0].length();
        int wordCount=words.length;
        int totalLen=wordLen*wordCount;
        Map<String,Integer> mp=new HashMap<>();
        for(String w: words) mp.put(w,mp.getOrDefault(w,0)+1);
        for(int offset=0;offset<wordLen;offset++){
            int l=offset,c=0;
            Map<String,Integer> temp=new HashMap<>();
            for(int r=offset;r+wordLen<=s.length();r+=wordLen)
            {
                String w=s.substring(r,r+wordLen);
                if(mp.containsKey(w)){
                    temp.put(w,temp.getOrDefault(w,0)+1);
                    c++;
                    while(temp.get(w)>mp.get(w)){
                        String leftWord=s.substring(l,l+wordLen);
                        temp.put(leftWord,temp.get(leftWord)-1);
                        l+=wordLen;
                        c--;
                    }
                    if(c==wordCount) res.add(l);
                }
                else{
                    temp.clear();
                    l=r+wordLen;
                    c=0;
                }
            }
        }
        return res;
    }
}


// Approach 1:
// “Take the substring, split it fully, then check. Even if the first word is wrong, you still check everything.”

// Approach 2:
// “Build the substring word by word. If something is wrong, stop immediately. Don’t waste time checking the rest.”
// 1. Brute Force

// Word length = wlen, total length = wlen * words.length

// For each index i in s:

// Take substring of length totalLen

// Split into chunks of size wlen

// Check if it matches words (using hashmap)

// ⏱️ O(N * W * L)
// (N = length of s, W = number of words, L = word length)
// Too slow for large inputs
// import java.util.*;

// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         List<Integer> res = new ArrayList<>();
//         if (s == null || s.length() == 0 || words.length == 0) return res;

//         int wordLen = words[0].length();
//         int totalLen = wordLen * words.length;
//         Map<String, Integer> wordCount = new HashMap<>();
//         for (String w : words) wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);

//         for (int i = 0; i <= s.length() - totalLen; i++) {
//             String sub = s.substring(i, i + totalLen);
//             Map<String, Integer> seen = new HashMap<>();
//             for (int j = 0; j < totalLen; j += wordLen) {
//                 String w = sub.substring(j, j + wordLen);
//                 seen.put(w, seen.getOrDefault(w, 0) + 1);
//             }
//             if (seen.equals(wordCount)) res.add(i);
//         }
//         return res;
//     }
// }

// 2. Sliding Window + HashMap (Optimal)

// Build a frequency map of words

// Slide through s using a window of length totalLen

// Inside the window, split into chunks of wlen

// Use a second map to check if counts match

// If yes → record index
// import java.util.*;

// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         List<Integer> res = new ArrayList<>();
//         if (s == null || s.length() == 0 || words.length == 0) return res;

//         int wordLen = words[0].length();
//         int totalLen = wordLen * words.length;

//         Map<String, Integer> wordCount = new HashMap<>();
//         for (String w : words) wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);

//         for (int i = 0; i <= s.length() - totalLen; i++) {
//             Map<String, Integer> seen = new HashMap<>();
//             int j = 0;
//             while (j < words.length) {
//                 String w = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
//                 if (!wordCount.containsKey(w)) break;
//                 seen.put(w, seen.getOrDefault(w, 0) + 1);
//                 if (seen.get(w) > wordCount.get(w)) break;
//                 j++;
//             }
//             if (j == words.length) res.add(i);
//         }
//         return res;
//     }
// }

// import java.util.*;

// class Solution {
//     public List<Integer> findSubstring(String s, String[] words) {
//         List<Integer> res = new ArrayList<>();
//         if (s == null || s.length() == 0 || words.length == 0) return res;

//         int wordLen = words[0].length();
//         int wordCount = words.length;
//         int totalLen = wordLen * wordCount;

//         Map<String, Integer> target = new HashMap<>();
//         for (String w : words) target.put(w, target.getOrDefault(w, 0) + 1);

//         for (int offset = 0; offset < wordLen; offset++) {
//             int left = offset, count = 0;
//             Map<String, Integer> window = new HashMap<>();
            
//             for (int right = offset; right + wordLen <= s.length(); right += wordLen) {
//                 String w = s.substring(right, right + wordLen);
                
//                 if (target.containsKey(w)) {
//                     window.put(w, window.getOrDefault(w, 0) + 1);
//                     count++;
                    
//                     while (window.get(w) > target.get(w)) {
//                         String leftWord = s.substring(left, left + wordLen);
//                         window.put(leftWord, window.get(leftWord) - 1);
//                         count--;
//                         left += wordLen;
//                     }
                    
//                     if (count == wordCount) res.add(left);
//                 } else {
//                     window.clear();
//                     count = 0;
//                     left = right + wordLen;
//                 }
//             }
//         }
//         return res;
//     }
// }
// offset = 0 → check indices 0,3,6,9…

// offset = 1 → check indices 1,4,7,10…

// offset = 2 → check indices 2,5,8,11…

