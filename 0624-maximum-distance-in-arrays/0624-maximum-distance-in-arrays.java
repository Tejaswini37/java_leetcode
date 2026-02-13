class Solution {
    public int maxDistance(List<List<Integer>> a) {
        int minval=a.get(0).get(0);
        int maxval=a.get(0).get(a.get(0).size()-1);
        int ans=0;
        for(int i=1;i<a.size();i++){
            List<Integer> cur=a.get(i);
            int curmin=cur.get(0);
            int curmax=cur.get(cur.size()-1);
            // min,max from 2 differnt arrays
            ans=Math.max(ans,maxval-curmin);
            ans=Math.max(ans,curmax-minval);
            // upadate
            minval=Math.min(minval,curmin);
            maxval=Math.max(maxval,curmax);
        }
        return ans;
    }
}
// class Solution {
//     public int maxDistance(List<List<Integer>> arrays) {

//         int minVal = arrays.get(0).get(0);
//         int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);

//         int ans = 0;

//         for (int i = 1; i < arrays.size(); i++) {
//             List<Integer> curr = arrays.get(i);

//             int currMin = curr.get(0);
//             int currMax = curr.get(curr.size() - 1);

//             // compute max distance using different arrays
//             ans = Math.max(ans, Math.abs(currMax - minVal));
//             ans = Math.max(ans, Math.abs(maxVal - currMin));

//             // update global min & max
//             minVal = Math.min(minVal, currMin);
//             maxVal = Math.max(maxVal, currMax);
//         }

//         return ans;
//     }
// }
