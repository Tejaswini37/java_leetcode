class Solution {
    public String reorganizeString(String s) {
        int freq[]=new int[26];
        for(char c : s.toCharArray()) freq[c-'a']++;
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->b[0]-a[0]
        );
        for(int i=0;i<26;i++){
            if(freq[i]>0) pq.add(new int[]{freq[i],i});
        }
        StringBuilder sb=new StringBuilder();
        int prev[]=null;
        while(!pq.isEmpty()){
            int cur[]=pq.poll();
            sb.append((char)(cur[1]+'a'));
            cur[0]--;
            // Put previous back into heap if it still has count
            if(prev!=null && prev[0]>0) 
                pq.add(prev);

            // Mark current as previous (to avoid adjacent same chars)
            prev=cur;
        }
        return s.length()==sb.length() ? sb.toString() : "";
    }
}