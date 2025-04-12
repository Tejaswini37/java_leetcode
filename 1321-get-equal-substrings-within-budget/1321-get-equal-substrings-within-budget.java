class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost=0;
        int maxLength=0;
        int l=0;
        for(int r=0;r<s.length();r++){
            
                cost+=Math.abs(s.charAt(r)-t.charAt(r));
                while(cost>maxCost){
                    cost-=Math.abs(s.charAt(l)-t.charAt(l));
                    l++;
                }
            
            maxLength=Math.max(r-l+1,maxLength);
        }
        return maxLength;
    }
}