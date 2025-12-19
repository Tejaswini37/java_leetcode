class Solution {
    public String reverseWords(String s) {
        String vowels="aeiou";
        // HashMap<String,Integer> hm=new HashMap<>();
        // HashSet<String> hs=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        String words[]=s.split(" ");
        int first=0;
        for(char ch : words[0].toCharArray()){
                if(vowels.indexOf(ch)!=-1) first++;
        }
        sb.append(words[0]);
        for(int i=1;i<words.length;i++){
            sb.append(" ");
            String x=words[i];
            int c=0;
            for(char ch : x.toCharArray()){
                if(vowels.indexOf(ch)!=-1) c++;
            }
            if(c==first) {
                
                sb.append(new StringBuilder(x).reverse());
            }
            else sb.append(x);
        }

        return sb.toString();
    }
}