class Solution {
    public int maxFreqSum(String s) {
        int freq[]=new int[128];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }
        int maxVow=0,maxCon=0;
        for(char ch: s.toCharArray()){
            if(freq[ch-'a']==0) continue;
            if("aeiouAEIOU".indexOf(ch)==-1){
                maxCon=Math.max(maxCon,freq[ch-'a']);
            }
            else maxVow=Math.max(maxVow,freq[ch-'a']);
        }
        return maxCon+maxVow;
    }
}