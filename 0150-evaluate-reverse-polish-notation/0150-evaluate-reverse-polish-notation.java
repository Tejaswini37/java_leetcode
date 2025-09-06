class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        int num=0;
        int res=1;
        for(String x :tokens){
            // if(x=="+" || x=="-" || x=="*" || x=="/"){
            if(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")){
                int a=st.pop();
                int b=st.pop();
                switch(x){
                    case "+":st.push(b+a); break;
                    case "-":st.push(b-a); break;
                    case "*":st.push(b*a); break;
                    case "/":st.push(b/a); break;
                }
            }
            else st.push(Integer.parseInt(x));
        }
        return st.pop();
    }
}