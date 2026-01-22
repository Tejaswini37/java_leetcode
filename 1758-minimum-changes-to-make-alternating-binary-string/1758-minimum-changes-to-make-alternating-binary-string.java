class Solution {
    public int minOperations(String s) {
        // check if first is 0 
        // for 1 and then take max  of 2
        int start0=0;
        int start1=0; //start with 1
        for(int i=0;i<s.length();i++){
            char expected0 = (i%2==0)?'0':'1';
            char expected1 = (i%2==0)?'1':'0';
            if(s.charAt(i)!=expected0) start0++;
            if(s.charAt(i)!=expected1) start1++;
        }
        return Math.min(start0,start1);
    }
}