class Solution {
    public boolean checkValidString(String s) {
        int l=0;
        int r=0;
        for(char ch: s.toCharArray()){
            if(ch=='('){
                l++;
                r++;
            }
            else if(ch==')'){
                l--;
                r--;
            }
            else{
                //let *=(
                r++;
                //let *=)
                l--;
            }
            if(r<0) return false;
            if(l<0) l=0; // *=''
        }
        return l==0;
    }
}