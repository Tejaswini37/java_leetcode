class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int freq[]=new int[26];
        for(char c : s.toCharArray()){
            freq[c-'a']++;
        }
        StringBuilder sb=new StringBuilder();
        int i=25; //start from z
        while(i>=0){
            if(freq[i]==0){
                i--;
                continue;
            }
            int use=Math.min(freq[i],repeatLimit);
            for(int k=0;k<use;k++){
                sb.append((char)(i+'a'));
            }
            freq[i]-=use;
            // if still more of same char left, we need a breaker
            if(freq[i]>0){
                int j=i-1;
                while(j>=0 && freq[j]==0) j--;
                // no smaller character to break--> stop
                if(j<0) break;
                sb.append((char)(j+'a'));
                freq[j]--;
            }
        }
        return sb.toString();
    }
}
