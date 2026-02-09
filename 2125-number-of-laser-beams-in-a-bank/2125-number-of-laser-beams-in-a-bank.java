class Solution {
    public int numberOfBeams(String[] bank) {
        int prev=0,ans=0;
        for(String r : bank){
            int cur=0;
            for(char c : r.toCharArray()){
                if(c=='1') cur++;
            }
            if(cur>0){
                ans+=prev*cur;
                prev=cur;
            }
        }
        return ans;
    }
}
