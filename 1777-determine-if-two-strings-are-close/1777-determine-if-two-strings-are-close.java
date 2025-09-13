class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length()!=word2.length()) return false;
       int freq1[]=new int[26];
       int freq2[]=new int[26];
       for(char ch: word1.toCharArray()) freq1[ch-'a']++;
       for(char ch: word2.toCharArray()) freq2[ch-'a']++; 
       for(int i=0;i<26;i++){
        if(freq1[i]==freq2[i]) continue;
        if(freq1[i]==0 || freq2[i]==0) return false;
       }
        // Step 2: Check frequency multiset
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]) return false;
        }
       return true;
    }
}

// They must have the same set of characters
// The multiset of character frequencies must be the same (order doesn’t matter because we can rearrange).
// Example: "aabbccc" (counts [2,2,3]) and "xxxyyyz" (counts [3,2,2]) ✅