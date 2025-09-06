class Solution {
    public int longestConsecutive(int[] nums) {
        int ans=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int n:nums){
            if(!hm.containsKey(n)){
                int left=(hm.containsKey(n-1))?hm.get(n-1):0;
                int right=(hm.containsKey(n+1))?hm.get(n+1):0;
                int sum=left+right+1;
                hm.put(n,sum);
                ans=Math.max(ans,sum);
                hm.put(n-left,sum);
                hm.put(n+right,sum);
            }
            else continue;
        }
        return ans;
    }
}

// public int longestConsecutive(int[] num) {
//     int res = 0;
//     HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//     for (int n : num) {
//         if (!map.containsKey(n)) {
//             int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
//             int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
//             // sum: length of the sequence n is in
//             int sum = left + right + 1;
//             map.put(n, sum);
            
//             // keep track of the max length 
//             res = Math.max(res, sum);
            
//             // extend the length to the boundary(s)
//             // of the sequence
//             // will do nothing if n has no neighbors
//             map.put(n - left, sum);// see example for understanding
//             map.put(n + right, sum);
//         }
//         else {
//             // duplicates
//             continue;
//         }
//     }
//     return res;
// }

// Step by Step:

// Insert 100

// left=0, right=0 → sum=1

// map = {100=1}

// update boundaries → {100=1}

// res = 1

// Insert 4

// left=0, right=0 → sum=1

// map = {100=1, 4=1}

// res = 1

// Insert 200

// left=0, right=0 → sum=1

// map = {100=1, 4=1, 200=1}

// res = 1

// Insert 1

// left=0, right=0 → sum=1

// map = {100=1, 4=1, 200=1, 1=1}

// res = 1

// Insert 3

// left= map.get(2)=0, right= map.get(4)=1 → sum = 0+1+1 = 2

// map.put(3,2)

// update boundaries:

// map.put(3-0,2) → map.put(3,2)

// map.put(3+1,2) → map.put(4,2)

// map = {100=1, 200=1, 1=1, 3=2, 4=2}

// res = 2

// Insert 2

// left= map.get(1)=1, right= map.get(3)=2 → sum = 1+2+1 = 4

// map.put(2,4)

// update boundaries:

// map.put(2-1,4) → map.put(1,4)

// map.put(2+2,4) → map.put(4,4)

// map = {100=1, 200=1, 2=4, 1=4, 3=2, 4=4}

// res = 4

// But notice: we don’t update every number inside the sequence (which would be O(n²) in worst case).
// \U0001f449 Instead, we only update the boundaries (leftmost & rightmost numbers of the sequence).
// When we form/merge sequences, we only need to update the left boundary and the right boundary with the new total length.
// This way:

// If a new number attaches later, we can quickly find sequence length from the nearest boundary.

// Avoids updating all middle numbers (saves time).

// That’s why the solution is O(n).
