class Solution {
    public int partitionString(String s) {
        boolean seen[]=new boolean[26];
        int partitions=1;
        for(char c : s.toCharArray()){
            if(seen[c-'a']){
                //start new Substring
                partitions++;
                seen=new boolean[26];
            }
            seen[c-'a']=true;
        }
        return partitions;
    }
}
