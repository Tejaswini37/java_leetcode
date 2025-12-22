class Solution {
    public boolean canExpand(int i,int j,String strs[]){
        for(String s:strs){
            if(s.charAt(i)>s.charAt(j)) return false;
        }
        return true;
    }
    public int solve(int prev,int cur,String[] strs,int m,int dp[][]){
        if(cur==m) return 0;
        if(dp[prev+1][cur]!=-1) return dp[prev+1][cur]; 
        // 1.skip
        int nottake=solve(prev,cur+1,strs,m,dp);
        int take=0;
        // Option 2: take current column if valid
        if(prev==-1 || canExpand(prev,cur,strs)){
            take=1+solve(cur,cur+1,strs,m,dp);
        }
        return dp[prev+1][cur]=Math.max(take,nottake);
    }
    public int minDeletionSize(String[] strs) {
       int m=strs[0].length();
       // prev index from -1..m-1, shift by +1
       int dp[][]=new int[m+1][m];
       for(int r[] : dp) Arrays.fill(r,-1);
       int maxlen=solve(-1,0,strs,m,dp);
       return m-maxlen; 
    }
}
// prev index from -1..m-1, shift by +1
// class Solution {
//     public boolean canExpand(int i,int j,String strs[]){
//         for(String s:strs){
//             if(s.charAt(i)>s.charAt(j)) return false;
//         }
//         return true;
//     }
//     public int solve(int prev,int cur,String[] strs,int m){
//         if(cur==m) return 0;
//         // 1.skip
//         int nottake=solve(prev,cur+1,strs,m);
//         int take=0;
//         // Option 2: take current column if valid
//         if(prev==-1 || canExpand(prev,cur,strs)){
//             take=1+solve(cur,cur+1,strs,m);
//         }
//         return Math.max(take,nottake);
//     }
//     public int minDeletionSize(String[] strs) {
//        int m=strs[0].length();
//        int maxlen=solve(-1,0,strs,m);
//        return m-maxlen; 
//     }
// }