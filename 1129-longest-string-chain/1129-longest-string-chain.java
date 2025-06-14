class Solution {
    public static boolean compare(String s1,String s2){
        if(s1.length()!=s2.length()+1) return false;
        int i1=0,i2=0;
        while(i1<s1.length()){
            if(i2<s2.length() && s1.charAt(i1)==s2.charAt(i2)){
                i1++;
                i2++;
            }
            else i1++;
        }
        return i1==s1.length() && i2==s2.length();
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int n=words.length;
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int maxi=0;
        for(int i=0;i<n;i++){
            for(int prev=0;prev<i;prev++){
                if(compare(words[i],words[prev]) && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                }
            }
            maxi=Math.max(maxi,dp[i]);
        }
        return maxi;
    }
}