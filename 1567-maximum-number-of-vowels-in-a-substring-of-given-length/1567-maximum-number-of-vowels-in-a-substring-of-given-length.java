class Solution {
    public int maxVowels(String s, int k) {
        int c=0;
        for(int i=0;i<k;i++){
            char ch=s.charAt(i);
            if("aeiou".indexOf(ch)!=-1) c++;
        }
        int res=c;
        for(int i=k;i<s.length();i++){
            char left=s.charAt(i-k);
            if("aeiou".indexOf(left)!=-1) c--;
            char ch=s.charAt(i);
            if("aeiou".indexOf(ch)!=-1) c++;
            res=Math.max(res,c);
        }
        return res;
    }
}