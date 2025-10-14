class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=2*n-1;i>=0;i--){
            int ind=i%n;
            int cur_ele=nums[ind];
            while(!st.isEmpty() && st.peek()<=cur_ele) st.pop();
            if(i<n){
                if(st.isEmpty()) ans[i]=-1;
                else ans[i]=st.peek();
            }
            st.push(cur_ele);
        }
        return ans;
    }
}

// public int[] nextGreaterElements(int[] arr) {
//         int n = arr.length;

//         // To store the next greater elements
//         int[] ans = new int[n];
//         Arrays.fill(ans, -1);

//         // Traverse each element to find its next greater
//         for (int i = 0; i < n; i++) {
//             int currEle = arr[i];

//             // Look ahead in circular manner
//             for (int j = 1; j < n; j++) {
//                 int ind = (i + j) % n;

//                 if (arr[ind] > currEle) {
//                     ans[i] = arr[ind];
//                     break;
//                 }
//             }
//         }

//         return ans;
//     }
// }