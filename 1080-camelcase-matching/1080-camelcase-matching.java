class Solution {
    public static boolean helper(String s,String p){
        int i=0,j=0;
        while(i<s.length()){
            if(j<p.length() && s.charAt(i)==p.charAt(j)){
                i++;
                j++;
            }
            else if(Character.isLowerCase(s.charAt(i))) i++;
            else return false;
        }
        
        return j==p.length();
    }
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            ans.add(helper(queries[i],pattern));
        } 
        return ans;
    }
}