class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans=new ArrayList<>();
        int maxi=candies[0];
        for(int c: candies) maxi=Math.max(maxi,c);
        for(int c: candies){
            ans.add(c+extraCandies>=maxi);
        }
        return ans;
    }
}