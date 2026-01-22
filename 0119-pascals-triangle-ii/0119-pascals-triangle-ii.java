class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>();
        ans.add(1);
        long prev=1;
        for(int i=1;i<=rowIndex;i++){
            long next=prev*(rowIndex-i+1)/i;
            ans.add((int)next);
            prev=next;
        }
        return ans;
    }
}
// public class Solution {
//     public List<Integer> getRow(int rowIndex) {
//         List<Integer> res = new ArrayList<>();
//         res.add(1);
//         long prev = 1;
//         for (int k = 1; k <= rowIndex; k++) {
//             long next_val = prev * (rowIndex - k + 1) / k;
//             res.add((int) next_val);
//             prev = next_val;
//         }
//         return res;
//     }
// }