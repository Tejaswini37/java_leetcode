class Solution {
    public int heightChecker(int[] heights) {
        int c[]=new int[101];
        for(int h: heights) c[h]++;
        int res=0,curheight=0;
        for(int h:heights){
            while(c[curheight]==0) curheight++;
            if(curheight!=h) res++;
            c[curheight]--;
        }
        return res;
    }
}