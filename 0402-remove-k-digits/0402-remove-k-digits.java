class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && k>0 && st.peek()>num.charAt(i)){
                k--;
                st.pop();
            }
            st.push(num.charAt(i));
        }
        while(k>0 && !st.isEmpty()){
            k--;
            st.pop();
        }
        StringBuilder sb=new StringBuilder();;
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while(sb.length()>0 && sb.charAt(0)=='0'){
            // sb.deleteCharAt(0);
            sb.replace(0,1,"");
        }
        return sb.length()>0?sb.toString():"0";


    }
}