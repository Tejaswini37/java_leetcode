class Solution {  // PREFIX+SUFIX COUNT
    public int[] minOperations(String boxes) {
//         Break the cost into:
// Cost from left side
// Cost from right side
// We compute both separately and add.
        int n=boxes.length();
        int ans[]=new int[n];
        int cost=0,box=0;
        //prefix
        for(int i=0;i<n;i++){
            ans[i]=cost;
            if(boxes.charAt(i)=='1') box++;
            cost+=box;
        }
        cost=0;
        box=0;
        for(int i=n-1;i>=0;i--){
            ans[i]+=cost;
            if(boxes.charAt(i)=='1') box++;
            cost+=box;
        }
        return ans;
    }
}
// class Solution {
//     public int[] minOperations(String boxes) {
//         int n = boxes.length();
//         int[] ans = new int[n];

//         for (int i = 0; i < n; i++) {
//             int cost = 0;
//             for (int j = 0; j < n; j++) {
//                 if (boxes.charAt(j) == '1') {
//                     cost += Math.abs(i - j);
//                 }
//             }
//             ans[i] = cost;
//         }
//         return ans;
//     }
// }
