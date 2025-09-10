class Solution {
    public int compress(char[] chars) {
        int ans=0;
        int n=chars.length;
        int read=0,write=0;
        while(read< n){
            char cur=chars[read];
            int c=0;
            while(read<n && chars[read]==cur){
                read++;
                c++;
            }
            chars[write++]=cur;
            if(c>1){
                for(char ch : String.valueOf(c).toCharArray()){
                    chars[write++]=ch;
                }
            }
        }
        return write;
    }
}