// class Solution {
//     public String longestPalindrome(String s) {
        
//     }
// }

// expand around the corner
class Solution {
    public int expand(String s, int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";
        int start=0, end=0;
        for(int i=0;i<s.length();i++){
            int len1=expand(s,i,i); //odd
            int len2=expand(s,i,i+1);  //even
            int len=Math.max(len1,len2);
            if(len> end-start){
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
}

// approach 1 check all substrings
// public String longestPalindrome(String s) {
//         int n = s.length();
//         String ans = "";
//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 String sub = s.substring(i, j + 1);
//                 if (isPalindrome(sub) && sub.length() > ans.length()) {
//                     ans = sub;
//                 }
//             }
//         }
//         return ans;
//     }