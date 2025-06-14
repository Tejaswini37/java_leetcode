class Solution {
    public int myAtoi(String s) {
        long ans=0;
        s=s.trim();
        int i=0;
        int sign=1;
        if (s.length() == 0) return 0;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        while(i<s.length()){
            if(s.charAt(i)!='0'){
                break;
            }
            i++;
        }
        if(i==s.length()) return 0;
        
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            ans=ans*10+(s.charAt(i)-'0');
            if(sign==1 && ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign==-1 && -ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }
        return (int)ans*sign;
    }
}