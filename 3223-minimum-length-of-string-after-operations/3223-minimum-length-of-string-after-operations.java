class Solution {
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int result = 0;
        for (int f : freq) {
            if (f == 0) continue;
            if (f < 3) {
                result += f;
            } else {
                result += (f % 2 == 0) ? 2 : 1;
            }
        }
        return result;
    }
}
// For each frequency:
// If f < 3 → add f
// Else:
// add 1 if f is odd
// add 2 if f is even