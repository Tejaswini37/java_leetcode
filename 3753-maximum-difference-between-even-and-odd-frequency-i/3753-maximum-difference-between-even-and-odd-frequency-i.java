class Solution {
    public int maxDifference(String s) {
        // maximum odd freq  - minimum even frequency
        int freq[]=new int[26];
        for(char ch: s.toCharArray()) freq[ch-'a']++;
        int maxOdd=1, minEven=s.length();
        for(int f:freq){
            if(f!=0){
                if((f&1)==0) minEven=Math.min(f,minEven);
                else maxOdd=Math.max(f,maxOdd);
            }
        }
        return maxOdd-minEven;
    }
}