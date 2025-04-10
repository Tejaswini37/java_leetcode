class Solution {
    public boolean canTransform(String start, String result) {
        int p1=0,p2=0;
        int n=start.length();
        while(p1<=n && p2<=n){
            while(p1<n && start.charAt(p1)=='X') p1++;
            while(p2<n && result.charAt(p2)=='X') p2++;
            if(p1==n && p2==n) return true;
            if(p1==n || p2==n) return false;
            char c1=start.charAt(p1);
            char c2=result.charAt(p2);
            
            if((c1=='L' && p1<p2) || (c1=='R' && p1>p2) ) return false;
            if(c1!=c2) return false;
            p1++;
            p2++;
            
        }
        return true;

    }
}
// start =
// "XXXXXLXXXX"
// result =
// "LXXXXXXXXX"

// Use Testcase
// Output
// false
// Expected
// true