class Solution {
    public int minimumLength(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r && s.charAt(l) == s.charAt(r)) {
            char ch = s.charAt(l);

            // remove same char from left
            while (l <= r && s.charAt(l) == ch) {
                l++;
            }

            // remove same char from right
            while (l <= r && s.charAt(r) == ch) {
                r--;
            }
        }

        return r - l + 1;
    }
}

// class Solution {
//     public int minimumLength(String s) {
        
//     }
// }