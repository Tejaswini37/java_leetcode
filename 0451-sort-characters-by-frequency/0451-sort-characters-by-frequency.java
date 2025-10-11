class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> hm=new HashMap<>();
        for(char c: s.toCharArray()){
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        List<Character> sorted=new ArrayList<>(hm.keySet());
        Collections.sort(sorted,(a,b)->hm.get(b)-hm.get(a));
        StringBuilder sb=new StringBuilder();
        for(char c: sorted){
            sb.append(String.valueOf(c).repeat(hm.get(c)));
        }
        return sb.toString();
    }
}



// class Solution {
//     public String frequencySort(String s) {
//         Map<Character, Integer> hm = new HashMap<>();
        
//         for (char c : s.toCharArray()) {
//             hm.put(c, hm.getOrDefault(c, 0) + 1);
//         }
        
//         PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
//             (a, b) -> b.getValue() - a.getValue()
//         );
        
//         pq.addAll(hm.entrySet());
        
//         StringBuilder result = new StringBuilder();
//         while (!pq.isEmpty()) {
//             Map.Entry<Character, Integer> entry = pq.poll();
//             result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
//         }
        
//         return result.toString();
//     }
// }

