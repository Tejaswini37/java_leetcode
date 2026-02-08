class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int totalOnes=0;
        for(int x : nums) totalOnes+=x;
        if(totalOnes==0 || totalOnes==n) return 0;
        int maxOnes=0;
        int curOnes=0;
        int left=0;
        //sliding window over circular array
        for(int right=0;right<2*n;right++){
            curOnes+=nums[right%n];
            if(right-left+1>totalOnes){
                curOnes-=nums[left%n];
                left++;
            }
            if(right-left+1==totalOnes){
                maxOnes=Math.max(maxOnes,curOnes);
            }
        }
        return totalOnes-maxOnes;
    }
}
// minimum swaps = totalOnes - maxOnesInWindow
// We are looking for a window of size totalOnes
