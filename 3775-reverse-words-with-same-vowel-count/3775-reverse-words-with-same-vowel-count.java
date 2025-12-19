// class Solution {
//     public String reverseWords(String s) {
//         String vowels="aeiou";
//         // HashMap<String,Integer> hm=new HashMap<>();
//         // HashSet<String> hs=new HashSet<>();
//         StringBuilder sb=new StringBuilder();
//         String words[]=s.split(" ");
//         int first=0;
//         for(char ch : words[0].toCharArray()){
//                 if(vowels.indexOf(ch)!=-1) first++;
//         }
//         sb.append(words[0]);
//         for(int i=1;i<words.length;i++){
//             sb.append(" ");
//             String x=words[i];
//             int c=0;
//             for(char ch : x.toCharArray()){
//                 if(vowels.indexOf(ch)!=-1) c++;
//             }
//             if(c==first) {
                
//                 sb.append(new StringBuilder(x).reverse());
//             }
//             else sb.append(x);
//         }

//         return sb.toString();
//     }
// }

class Solution {

    private boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||
               c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }

    public String reverseWords(String s) {

        StringBuilder result = new StringBuilder();
        StringBuilder word = new StringBuilder();

        int targetVowels = -1;

        for (int i = 0; i <= s.length(); i++) {

            if (i == s.length() || s.charAt(i) == ' ') {

                int count = 0;
                for (int j = 0; j < word.length(); j++) {
                    if (isVowel(word.charAt(j)))
                        count++;
                }

                if (targetVowels == -1) {
                    targetVowels = count;
                    result.append(word);
                } else if (count == targetVowels) {
                    result.append(word.reverse());
                    word.reverse(); // restore
                } else {
                    result.append(word);
                }

                if (i < s.length())
                    result.append(" ");

                word.setLength(0);
            } else {
                word.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
