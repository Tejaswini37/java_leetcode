class Solution {
    public int countBinarySubstrings(String s) {
        int n=s.length();
        int c=0;
        int prev=0,curr=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)) curr++;
            else{
                c+=Math.min(prev,curr);
                prev=curr;
                curr=1;
            }
        }
        c+=Math.min(prev,curr);
        return c;
    }
}