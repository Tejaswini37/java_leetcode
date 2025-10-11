class Solution {
    public int maxDepth(String s) {
        int c=0, max=0;
        for(char ch: s.toCharArray()){
            if(ch=='(') c++;
            else if(ch==')') c--;
            max=Math.max(max,c);
        }
        return max;
    }
}