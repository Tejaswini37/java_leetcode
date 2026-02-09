class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs,(a,b)->(a[0]-a[1])-(b[0]-b[1]));
        int n=costs.length/2;
        int total=0;
        for(int i=0;i<costs.length;i++){
            if(i<n)total+=costs[i][0]; // city a
            else total+=costs[i][1]; //city b
        }
        return total;
    }
}
// Sort by (A − B).
// First half → A, second half → B.