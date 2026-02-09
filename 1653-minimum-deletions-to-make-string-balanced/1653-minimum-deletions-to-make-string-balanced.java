class Solution {
    public int minimumDeletions(String s) {
        int bcount=0,deletions=0;
        for(char c : s.toCharArray()){
            if(c=='b') bcount++;
            else{
                deletions=Math.min(deletions+1,bcount);
            }
        }
        return deletions;
    }
}
// If you see a 'b' → it’s fine (for now)
// If you see an 'a' after some 'b's → conflict ❌
