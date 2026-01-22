class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean c[]=new boolean[26];
        for(char x : allowed.toCharArray()) c[x-'a']=true;
        int ans=0;
        for(String s : words){
            boolean valid=true;
            for(char x : s.toCharArray()){
                if(!c[x-'a']) {
                    valid=false;
                    break;
                }
            }
            if(valid) ans++;
        }
        return ans;
    }
}