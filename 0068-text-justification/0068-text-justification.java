class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        int i=0;
        while(i<words.length){
            int j=i,len=0;
            // (j-i) indicates spaces for 3 words 2 gaps
            while(j<words.length && len+words[j].length()+(j-i)<=maxWidth){
                len+=words[j].length();
                j++;
            }
            int gaps=j-i-1;
            StringBuilder sb=new StringBuilder();
            // last word or one word == left justify
            if(j==words.length || gaps==0){
                for(int k=i;k<j;k++){
                    sb.append(words[k]);
                    if(k<j-1) sb.append(" ");
                }
                while(sb.length()<maxWidth) sb.append(" ");
            }
            else{
                int spaces=(maxWidth-len)/gaps;
                int extras=(maxWidth-len)%gaps;
                for(int k=i;k<j;k++){
                    sb.append(words[k]);
                    if(k<j-1){
                        //if extras present left justify
                        int final_spaces=spaces+(k-i<extras?1:0);
                        for(int s=0;s<final_spaces;s++) sb.append(" ");
                    }
                }
                
            }
            res.add(sb.toString());
            i=j;
        }
        return res;
    }
}

// Say we have words ["This","is","cool"] and maxWidth = 16.
// Words length = 4 + 2 + 4 = 10
// Gaps = 2 (between 3 words)
// Spaces needed = 16 - 10 = 6
// spaces = 6 / 2 = 3 (each gap gets 3 spaces)
// extra = 6 % 2 = 0 → no extra spaces

// Another case:
// Words = ["This","is","nice"], width=17.
// Word lengths = 4 + 2 + 4 = 10
// Spaces = 17 - 10 = 7
// Gaps = 2
// spaces = 7 / 2 = 3
// extra = 7 % 2 = 1
// Now:
// First gap (k - i = 0): gets 3 + 1 = 4 spaces
// Second gap (k - i = 1): gets 3 spaces

// spaces + (k - i < extra ? 1 : 0)
// \U0001f449 ensures even distribution of spaces + extra spaces to leftmost gaps.

// i = index of first word in the line
// j = index of first word not included in this line
// k = current word index in the line
// spaces = base number of spaces to insert between words
// extra = leftover spaces (because spaces don’t always divide evenly)