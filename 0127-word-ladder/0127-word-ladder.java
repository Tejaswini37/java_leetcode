class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(end)) return 0;
        Queue<String> q=new LinkedList<>();
        q.add(begin);
        int steps=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int s=0;s<size;s++){
                String word=q.poll();
                if(word.equals(end)) return steps;
                char a[]=word.toCharArray();
                for(int i=0;i<a.length;i++){
                    char old=a[i];
                    for(char c='a';c<='z';c++){
                        a[i]=c;
                        String next=new String(a);
                        if(set.contains(next)){
                            q.add(next);
                            set.remove(next);
                        }
                    }
                    a[i]=old;
                }
            }
            steps++;
        }
        return 0;
    }
}
// class Pair{
//     String first;
//     int second;
//     Pair(String first,int second){
//         this.first=first;
//         this.second=second;
//     }
// }
// class Solution {
//     public int ladderLength(String start, String end, List<String> wordList) {
//         Queue<Pair> q=new LinkedList<>();
//         q.add(new Pair(start,1));
//         Set<String> set=new HashSet<>();
//         for(String x: wordList) set.add(x);
//         set.remove(start);
//         while(!q.isEmpty()){
//             String word=q.peek().first;
//             int steps=q.peek().second;
//             q.remove();
//             if(word.equals(end)) return steps;
//             for(int i=0;i<word.length();i++){
//                 for(char ch='a';ch<='z';ch++){
//                     char[] replaced=word.toCharArray();
//                     replaced[i]=ch;
//                     String replacedWord=new String(replaced);
//                     if(set.contains(replacedWord)==true){
//                         set.remove(replacedWord);
//                         q.add(new Pair(replacedWord,steps+1));
//                     }
//                 }
//             }
//         }
//         return 0;
//     }
// }