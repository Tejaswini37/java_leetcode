class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int c[]=new int[26];
        for(char x:magazine.toCharArray()) c[x-'a']++;
        for(char x: ransomNote.toCharArray()){
            c[x-'a']--;
            if(c[x-'a']==-1) return false;
        }
        return true;
    }
}