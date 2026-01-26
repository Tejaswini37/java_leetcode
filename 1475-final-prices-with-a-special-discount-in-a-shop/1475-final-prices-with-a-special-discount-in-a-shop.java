class Solution {
    public int[] finalPrices(int[] prices) {
        int n=prices.length;
        int last=prices[n-1];
        Stack<Integer> st=new Stack<>();
        st.push(prices[n-1]);
        for(int i=n-2;i>=0;i--){
            int cur=prices[i];
            while(!st.isEmpty() && st.peek()>cur) st.pop();
            if(!st.isEmpty()) prices[i]-=st.peek();
            st.push(cur);

        }
        return prices;
    }
}