class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0;
        int res=0;
        int a[]=new int[128];
        for(int j=0;j<s.length();j++){
            a[s.charAt(j)]++;
            while(a[s.charAt(j)]>1){
                a[s.charAt(i)]--;
                i++;
            }
            res=Math.max(res,j-i+1);
        }
        return res;
    }
}