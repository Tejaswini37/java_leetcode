class Solution {
    public static boolean ispalim(String s,int l,int r){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public static void bt(int start,String s,ArrayList<String> t,List<List<String>> ans){
        if(start==s.length()){
            ans.add(new ArrayList<>(t));
            return;
        }
        for(int i=start+1;i<=s.length();i++){
            String part=s.substring(start,i);
            if(ispalim(part,0,part.length()-1)){
                t.add(part);
                bt(i,s,t,ans);
                t.remove(t.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        bt(0,s,new ArrayList<String>(),ans);
        return ans;
    }
}