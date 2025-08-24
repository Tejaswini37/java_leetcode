class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit=0;
        int n=prices.length;
        int minbuy=prices[0];
        for(int i=1;i<n;i++){
            minbuy=Math.min(minbuy,prices[i]);
            maxprofit=Math.max(maxprofit,prices[i]-minbuy);
        }
        return maxprofit;
        
    }
}