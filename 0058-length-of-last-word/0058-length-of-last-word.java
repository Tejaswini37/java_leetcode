class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        String s1[]=s.split("\\s+");
        return s1[s1.length-1].length();
    }
}