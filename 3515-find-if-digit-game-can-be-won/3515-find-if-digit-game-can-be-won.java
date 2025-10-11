class Solution {
    public boolean canAliceWin(int[] nums) {
        int sd=0, dd=0;
        for(int n: nums){
            if(n<=9) sd+=n;
            else dd+=n;
        }
        return sd==dd?false:true;
    }
}