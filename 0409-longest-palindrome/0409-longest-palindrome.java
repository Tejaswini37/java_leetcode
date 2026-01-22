class Solution {
    public int longestPalindrome(String s) {
        int c[]=new int[52];
        for(char ch : s.toCharArray()){
            if('a'<=ch && ch<='z') c[ch-'a']++;
            else c[ch-'A'+26]++;
        }
        int ans=0;
        boolean hasOdd=false;
        for(int i=0;i<52;i++){
            if(c[i]%2==0) ans+=c[i];
            else{
                ans+=c[i]-1; // if 3 take 2 and mark odd
                hasOdd=true;
            }
        }
        if(hasOdd) return ans+1;
        return ans;
    }
}
// class Solution {
//     public int longestPalindrome(String s) {

//         HashSet<Character> set = new HashSet<>();
//         int length = 0;

//         for (char c : s.toCharArray()) {
//             if (set.contains(c)) {
//                 set.remove(c);
//                 length += 2;
//             } else {
//                 set.add(c);
//             }
//         }

//         if (!set.isEmpty()) length++;

//         return length;
//     }
// }
