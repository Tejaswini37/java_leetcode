// class Solution {
//     public List<String> wordSubsets(String[] words1, String[] words2) {
        
//     }
// }
class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {

        int[] maxFreq = new int[26];

        // Step 1: Build max frequency from words2
        for (String b : words2) {
            int[] freq = new int[26];
            for (char c : b.toCharArray()) {
                freq[c - 'a']++;
                maxFreq[c - 'a'] = Math.max(maxFreq[c - 'a'], freq[c - 'a']);
            }
        }

        List<String> result = new ArrayList<>();

        // Step 2: Check each word in words1
        for (String a : words1) {
            int[] freq = new int[26];
            for (char c : a.toCharArray()) {
                freq[c - 'a']++;
            }

            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                result.add(a);
            }
        }

        return result;
    }
}
