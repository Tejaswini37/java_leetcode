class Solution {
    public String sortVowels(String s) {
        String vowels="aeiouAEIOU";
        List<Character> al=new ArrayList<>();
        
        for(char c: s.toCharArray()){
            if(vowels.indexOf(c)!=-1) al.add(c);
        }
        Collections.sort(al);
        StringBuilder sb=new StringBuilder();
        int i=0;
        for(char c: s.toCharArray()){
            if(vowels.indexOf(c)==-1) sb.append(c);
            else{
                sb.append(al.get(i++));
            }
        }
        return sb.toString();
    }
}