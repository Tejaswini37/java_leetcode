class Solution {
    public int lastStoneWeightII(int[] stones) {
        // instead of taking 2 stones and computing , split the array into 2 halfs an take absolute difference between them
        // 2 3 4 3 5   (5+4)-(2+3+3)  9-8 =1
        // both are same
        int totalsum=0;
        for(int x:stones) totalsum+=x;
        int n=stones.length;
        boolean dp[][]=new boolean[n][totalsum+1];
        for(int i=0;i<n;i++) dp[i][0]=true; //target =0 upto any index is true
        //dp[x][y] means till index x we can achive target y or not = T | F
        //dp[i][j] = true means: using first i stones, we can make a subset with sum j.
         dp[0][stones[0]]=true;
        for(int i=1;i<n;i++){
            for(int tar=1;tar<=totalsum;tar++){
                boolean nottake=dp[i-1][tar];
                boolean take=false;
                if(stones[i]<=tar){
                    take=dp[i-1][tar-stones[i]];
                }
                dp[i][tar]=nottake | take;
            }
        } 
        // check the last row 
        // till index n-1 which target is achieved from [0 to totalsum]
        // s1=tar  s2=totalsum-s1
        // no need to check till totalsum . half is enough because remaining half is totalsum-s1
        int mini=Integer.MAX_VALUE;
        for(int i=0;i<=(totalsum/2);i++){
            if(dp[n-1][i])
            mini=Math.min(mini,Math.abs((totalsum-i)-i));
        }
        return mini;
    }
}