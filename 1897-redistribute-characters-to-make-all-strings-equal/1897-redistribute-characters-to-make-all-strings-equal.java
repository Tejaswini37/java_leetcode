class Solution {
    public boolean makeEqual(String[] words) {
        int c[]=new int[26];
        int n=words.length;
        for(String w : words){
            for(char ch : w.toCharArray()){
                c[ch-'a']++;
            }
        }
        for(int x : c){
            if(x%n!=0) return false;
        }
        return true;
    }
}