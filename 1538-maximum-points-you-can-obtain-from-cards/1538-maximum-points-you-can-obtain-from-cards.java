class Solution {
    
    public int maxScore(int[] cardPoints, int k) {
        int tsum=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        int left=0;
        int right=0;
        for(int i=0;i<cardPoints.length;i++){
            tsum+=cardPoints[i];
        }
        if(k==cardPoints.length) return tsum;
        k=cardPoints.length-k;
        while(right<cardPoints.length){
            sum+=cardPoints[right];
            if(right-left+1<k) right++;
            else if(right-left+1==k){
                ans=Math.min(ans,sum);
                sum-=cardPoints[left];
                left++;
                right++;
            }
        }
        return tsum-ans;
    }
}