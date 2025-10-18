class Solution {
    private int[] findNSE(int a[]){
        int n=a.length;
        int ans[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1; i>=0;i--){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return ans;
    }
    private int[] findPSEE(int a[]){
        int n=a.length;
        int ans[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && a[st.peek()]>a[i]){
                st.pop();
            }
            ans[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return ans;
    }
    public int sumSubarrayMins(int[] arr) {
        int ans=0, n=arr.length;
        int mod =(int)1e9 + 7;

        int nse[]=findNSE(arr);
        int psee[]=findPSEE(arr);
        int sum=0;
        // traverse each ele to compute its contribution
        for(int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            //total subarrays where a[i] is min
            long freq=left*right*1L;
            int val=(int)((freq*arr[i]) % mod);
            sum=(sum+val)%mod;
        } 
        
        return sum;
    }
}
// Use a stack to find the index of the next smaller element to the right for each position
// Use another stack to find the index of the previous smaller or equal element to the left for each position
// For each element, determine how many subarrays it appears in as the minimum using its NSE and PSEE (1,1) indices
// Calculate the contribution of each element by multiplying its value with its frequency
// Add each contribution to a total sum
// Return the total sum modulo 10^9 + 7


// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int ans=0, n=arr.length;
//         int mod =(int)1e9 + 7;
//         for(int i=0;i<n;i++){
//             int min=Integer.MAX_VALUE;
//             for(int j=i;j<n;j++){
//                 min=Math.min(min,arr[j]);
//                 ans=(ans+min)%mod;
//             }
//         }
//         return ans;
//     }
// }