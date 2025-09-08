class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(start,0));
        Set<String> set=new HashSet<>();
        for(String x: bank) set.add(x);
        set.remove(start);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            if(word.equals(end)) return steps;
            for(int i=0;i<word.length();i++){
                for(char ch='A';ch<='Z';ch++){
                    char[] replaced=word.toCharArray();
                    replaced[i]=ch;
                    String replacedWord=new String(replaced);
                    if(set.contains(replacedWord)==true){
                        set.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return -1;
    }
}