class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words=text.split("\\s+");
        int count=0;
        for(int i=0;i<words.length;i++){
            int flag=1;
            for(char ch: brokenLetters.toCharArray()){
                if(words[i].indexOf(ch)!=-1) {
                    flag=0;
                    break;
                }
            }
            if(flag==1) count++;
        }
        return count;
    }
}