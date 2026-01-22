class Solution {
    public int maxScore(String s) {
        int ones=0;
        for(char ch : s.toCharArray()){
            if(ch=='1') ones++;
        }
        int leftzeros=0, maxscore=0;
        for(int i=0;i<s.length()-1;i++){
            char ch=s.charAt(i);
            if(ch=='0') leftzeros++;
            // else ones--
            maxscore=Math.max(maxscore,leftzeros+ones-i+leftzeros-1);
        }
        return maxscore;
    }
}
// class Solution {   wrong
//     public int maxScore  (String s) {
//         int ones=0;
//         for(char ch : s.toCharArray()){
//             if(ch=='1') ones++;
//         }
//         int leftzeros=0, maxscore=0;
//         for(int i=0;i<s.length()-1;i++){
//             char ch=s.charAt(i);
//             if(ch=='0') leftzeros++;
//             maxscore=Math.max(maxscore,leftzeros+ones-i+leftzeros)
//         }
//         return maxscore;
//     }
// }