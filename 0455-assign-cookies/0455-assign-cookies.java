class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int c=0;
        int i=0;
        for(int j=0;i<g.length && j<s.length;j++){
            if(g[i]<=s[j]){
                c++;
                i++;
            }
            
        }
        return c;
    }
}