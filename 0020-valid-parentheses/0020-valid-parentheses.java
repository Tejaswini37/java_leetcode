class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch: s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{') st.push(ch);
            else if(!st.isEmpty()){
                if(st.peek()=='(' && ch==')') st.pop();
                else if(st.peek()=='[' && ch==']') st.pop();
                else if(st.peek()=='{' && ch=='}') st.pop();
                else return false;
            }
            else return false;
        }
        return st.isEmpty();
    }
}