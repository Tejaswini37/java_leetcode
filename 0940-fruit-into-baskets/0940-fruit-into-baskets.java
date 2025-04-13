class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int l=0;
        int ans=0;
        int k=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int r=0;r<n;r++){
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            while(map.size()>2){
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }
            ans=Math.max(ans,(r-l+1));
        }
        return ans; 
    }
}