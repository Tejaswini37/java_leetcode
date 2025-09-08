class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set=new HashSet<>(Arrays.asList(bank));
        if(!set.contains(end)) return -1;
        char genes[]={'A','C','G','T'};
        Queue<String> q=new LinkedList<>();
        q.add(start);
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();
                if(word.equals(end)) return steps;
                char a[]=word.toCharArray();
                for(int pos=0;pos<word.length();pos++){
                    char old=a[pos];
                    for(char g : genes){
                        if(g==old) continue;
                        a[pos]=g;
                        String next=new String(a);
                        if(set.contains(next)){
                            q.add(next);
                            set.remove(next);
                        }
                    }
                    a[pos]=old;
                }

            }
            steps++;
        }
        return -1;
    }
}

// Each gene is a string of length 8.

// Valid characters are only {'A', 'C', 'G', 'T'}.

// In one mutation, you can change exactly one character in the gene string.

// You can only mutate into a gene if it exists in the bank.

// Goal → Find the minimum number of mutations from start to end.

// If it’s not possible, return -1.
// class Pair{
//     String first;
//     int second;
//     Pair(String first,int second){
//         this.first=first;
//         this.second=second;
//     }
// }
// class Solution {
//     public int minMutation(String start, String end, String[] bank) {
//         Queue<Pair> q=new LinkedList<>();
//         q.add(new Pair(start,0));
//         Set<String> set=new HashSet<>();
//         for(String x: bank) set.add(x);
//         set.remove(start);
//         while(!q.isEmpty()){
//             String word=q.peek().first;
//             int steps=q.peek().second;
//             q.remove();
//             if(word.equals(end)) return steps;
//             for(int i=0;i<word.length();i++){
//                 for(char ch='A';ch<='Z';ch++){
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
//         return -1;
//     }
// }

