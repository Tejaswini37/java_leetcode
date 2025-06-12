class Solution {
    public int helper(int ind1,int ind2,String s, String p,int dp[][]){
        if(ind1<0 && ind2<0) return 1;
        if(ind2<0 && ind1>=0) return 0;
        
        if(ind1<0 && ind2>=0){
            for(int i=0;i<=ind2;i++){
                if(p.charAt(i)!='*') return 0;
            }
            return 1;
        }
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if((s.charAt(ind1)==p.charAt(ind2) )|| p.charAt(ind2)=='?'){
            return dp[ind1][ind2]=helper(ind1-1,ind2-1,s,p,dp);
        }
        else if(p.charAt(ind2)=='*'){
            return dp[ind1][ind2]=(helper(ind1,ind2-1,s,p,dp)==1 || helper(ind1-1,ind2,s,p,dp)==1)?1:0;
        }
        return dp[ind1][ind2]=0;

    }
    public boolean isMatch(String s, String p) {
        int n=s.length(),m=p.length();
        int dp[][]=new int[n][m];
        for(int r[]:dp) Arrays.fill(r,-1);
        return helper(n-1,m-1,s,p,dp)==1;
    }
}


// class Solution {
//     public boolean helper(int ind1,int ind2,String s, String p){
//         if(ind1<0 && ind2<0) return true;
//         if(ind2<0 && ind1>=0) return false;
//         if(ind1<0 && ind2>=0){
//             for(int i=0;i<=ind2;i++){
//                 if(p.charAt(i)!='*') return false;
//             }
//             return true;
//         }
//         if((s.charAt(ind1)==p.charAt(ind2) )|| p.charAt(ind2)=='?'){
//             return helper(ind1-1,ind2-1,s,p);
//         }
//         else if(p.charAt(ind2)=='*'){
//             return helper(ind1,ind2-1,s,p) || helper(ind1-1,ind2,s,p);
//         }
//         return false;

//     }
//     public boolean isMatch(String s, String p) {
//         int n=s.length(),m=p.length();
//         return helper(n-1,m-1,s,p);
//     }
// }