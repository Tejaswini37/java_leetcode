class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int ans[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int prev=st.pop();
                ans[prev]=i-prev;
            }
            st.push(i);
        }
        return ans;
    }
}
// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int n = temperatures.length;
//         int[] ans = new int[n];
//         for (int i = 0; i < n; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (temperatures[j] > temperatures[i]) {
//                     ans[i] = j - i;
//                     break;
//                 }
//             }
//         }
//         return ans;
//     }
// }
