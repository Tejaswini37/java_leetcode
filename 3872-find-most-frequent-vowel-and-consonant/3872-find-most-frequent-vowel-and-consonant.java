class Solution {
    public int maxFreqSum(String s) {
        int freq[]=new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        int maxVow=0,maxCon=0;
        for(char ch: s.toCharArray()){
            if(freq[ch-'a']==0) continue;
            if("aeiou".indexOf(ch)==-1){
                maxCon=Math.max(maxCon,freq[ch-'a']);
            }
            else maxVow=Math.max(maxVow,freq[ch-'a']);
        }
        return maxCon+maxVow;
    }
}
// class Solution {
//     public int maxFreqSum(String s) {
//         int[] cnt = new int[26];
//         for (char c : s.toCharArray()) {
//             cnt[c - 'a']++;
//         }
//         int maxVowel = 0, maxConsonant = 0;
//         for (int i = 0; i < 26; i++) {
//             char c = (char)(i + 'a');
//             if (isVowel(c)) {
//                 maxVowel = Math.max(maxVowel, cnt[i]);
//             } else {
//                 maxConsonant = Math.max(maxConsonant, cnt[i]);
//             }
//         }
//         return maxVowel + maxConsonant;
//     }
//     private boolean isVowel(char c) {
//         return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
//     }
// }
