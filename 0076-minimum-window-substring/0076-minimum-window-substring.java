class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return new String();
        int l=0,r=0;
        int map[]=new int[128];
        for(char ch:t.toCharArray()) map[ch]++;
        char s1[]=s.toCharArray();
        int c=t.length(),minlength=Integer.MAX_VALUE;
        int minindex=0;
        while(r<s1.length){
            if(map[s1[r++]]-->0) c--;
            // map[s1[r]]--;
            while(c==0){
                if(r-l<minlength){
                    minindex=l;
                    minlength=r-l;
                }
                if(map[s1[l++]]++==0){
                    c++;
                }
            }
            
        }
        return minlength == Integer.MAX_VALUE ? new String() :new String(s1,minindex,minlength);
    }
}