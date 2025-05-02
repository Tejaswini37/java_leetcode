class Solution {
    public int maxNumberOfBalloons(String text) {
        String s="balon";
        HashMap<Character,Integer> h=new HashMap<>();
        for(char ch: text.toCharArray()){
            if(s.indexOf(ch)!=-1) h.put(ch,h.getOrDefault(ch,0)+1);
        }
        if(h.size()!=5) return 0;
        int min=Integer.MAX_VALUE;
        for( char ch : h.keySet()){
            if(ch=='l'|| ch=='o')
            min=Math.min(min,h.get(ch)/2);
            else min=Math.min(min,h.get(ch));
        }
        return min;
    }
}