class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n=score.length;
        String[] res=new String[n];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<n;i++) pq.add(new int[]{i,score[i]});
        int rank=1;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int idx=cur[0];
            if(rank==1) res[idx]="Gold Medal";
            else if(rank==2) res[idx]="Silver Medal";
            else if(rank==3) res[idx]="Bronze Medal";
            else res[idx]=String.valueOf(rank);
            rank++;
        }
        return res;
    }
}

// class Solution {
//     public String[] findRelativeRanks(int[] score) {
//         int n = score.length;
//         String[] result = new String[n];

//         // Create an array of indices
//         Integer[] indices = new Integer[n];
//         for (int i = 0; i < n; i++) {
//             indices[i] = i;
//         }

//         // Sort athletes by score descending
//         Arrays.sort(indices, (a, b) -> score[b] - score[a]);

//         // Assign ranks
//         for (int i = 0; i < n; i++) {
//             int idx = indices[i];
//             if (i == 0) result[idx] = "Gold Medal";
//             else if (i == 1) result[idx] = "Silver Medal";
//             else if (i == 2) result[idx] = "Bronze Medal";
//             else result[idx] = String.valueOf(i + 1);
//         }

//         return result;
//     }
// }

// class Solution {
//     public String[] findRelativeRanks(int[] score) {
//         TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
//         for (int i = 0; i < score.length; i++) {
//             map.put(score[i], i);
//         }

//         String[] res = new String[score.length];
//         int rank = 1;

//         for (int s : map.keySet()) {
//             int idx = map.get(s);
//             if (rank == 1) res[idx] = "Gold Medal";
//             else if (rank == 2) res[idx] = "Silver Medal";
//             else if (rank == 3) res[idx] = "Bronze Medal";
//             else res[idx] = String.valueOf(rank);
//             rank++;
//         }

//         return res;
//     }
// }
