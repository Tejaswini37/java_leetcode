class Solution {
    public int countKeyChanges(String s) {
        int ans=0;
        for(int i=1;i<s.length();i++){
            int diff=Math.abs(s.charAt(i)-s.charAt(i-1));
            if(diff!=32 && diff!=0) ans++;
        }
        return ans;
    }
}