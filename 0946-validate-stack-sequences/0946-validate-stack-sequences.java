class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st=new Stack<>();
        int idx=0,m=pushed.length,n=popped.length;
        for(int i=0;i<m;i++){
            st.push(pushed[i]);
            while(!st.isEmpty() && idx<n && st.peek()==popped[idx]){
                st.pop();
                idx++;
            }
        }
        return st.isEmpty();
    }
}