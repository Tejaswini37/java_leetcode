class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int ele: asteroids){
            boolean curele=false;
            while(!st.isEmpty() && ele<0 && st.peek()>0){
                int top=st.peek();
                if(top<-ele) {
                    st.pop();
                    continue;
                }
                else if(top==-ele) st.pop();
                curele=true;
                break;
            }
            if(!curele) st.push(ele);
        }
        int res[]=new int[st.size()];
        for(int i=st.size()-1;i>=0;i--) res[i]=st.pop();
        return res;
    }
}