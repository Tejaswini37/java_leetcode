class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int c[]=new int[26], n=s.length();
        int ans=-1;
        Arrays.fill(c,-1);
        for(int i=0;i<n;i++){
            int idx=s.charAt(i)-'a';
            if(c[idx]==-1) c[idx]=i;
            else {
                ans=Math.max(ans,i-c[idx]-1);
            }
        }
        return ans;
    }
}