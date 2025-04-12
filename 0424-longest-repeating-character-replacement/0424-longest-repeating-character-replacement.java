class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,maxFreq=0;
        int ans=1;
        int a[]=new int[26];
       
        for(int j=0;j<s.length();j++){
            a[s.charAt(j)-'A']++;
            maxFreq=Math.max(maxFreq,a[s.charAt(j)-'A']);
            while((j-i+1)-maxFreq>k){
                a[s.charAt(i)-'A']--;
                i++;
            }
            
            ans=Math.max(ans,j-i+1);
        }
        return ans;
    }
}