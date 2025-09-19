class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq=new HashMap<>();
        for(int n:nums){
            freq.put(n,freq.getOrDefault(n,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->freq.get(b)-freq.get(a));
        for(int key: freq.keySet()){
            pq.add(key);
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll();
        }
        return ans;
    }
}

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> freq = new HashMap<>();
//         for (int n : nums) {
//             freq.put(n, freq.getOrDefault(n, 0) + 1);
//         }

//         PriorityQueue<Map.Entry<Integer, Integer>> pq =
//             new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

//         pq.addAll(freq.entrySet());

//         int[] res = new int[k];
//         for (int i = 0; i < k; i++) {
//             res[i] = pq.poll().getKey();
//         }
//         return res;
//     }
// }

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         Map<Integer, Integer> freq = new HashMap<>();
//         for (int n : nums) {
//             freq.put(n, freq.getOrDefault(n, 0) + 1);
//         }

//         // bucket where index = frequency
//         List<Integer>[] bucket = new List[nums.length + 1];
//         for (int key : freq.keySet()) {
//             int f = freq.get(key);
//             if (bucket[f] == null) bucket[f] = new ArrayList<>();
//             bucket[f].add(key);
//         }

//         List<Integer> resList = new ArrayList<>();
//         for (int i = bucket.length - 1; i >= 0 && resList.size() < k; i--) {
//             if (bucket[i] != null) resList.addAll(bucket[i]);
//         }

//         int[] res = new int[k];
//         for (int i = 0; i < k; i++) res[i] = resList.get(i);
//         return res;
//     }
// }
