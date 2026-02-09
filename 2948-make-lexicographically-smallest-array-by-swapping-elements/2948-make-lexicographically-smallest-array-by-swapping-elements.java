class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        // store value and index;
        int a[][]=new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=nums[i];
            a[i][1]=i;
        }
        // sort by value;
        Arrays.sort(a,(b,c)->b[0]-c[0]);
        int i=0;
        while(i<n){
            int j=i;
            // find a grp where consecutive values differ <=limit
            while(j+1<n && a[j+1][0]-a[j][0]<=limit) j++;
            // collect indices and values of this group
            List<Integer> indices=new ArrayList<>();
            List<Integer> values=new ArrayList<>();
            for(int k=i;k<=j;k++){
                indices.add(a[k][1]);
                values.add(a[k][0]);
            }
            //sort both
            Collections.sort(indices);
            //assign smallest values to smallest indices;
            for(int k=0;k<indices.size();k++){
                nums[indices.get(k)]=values.get(k);
            }
            i=j+1;
        }
        return nums;
    }
}
// A group means:
// Numbers that can reach each other by allowed swaps
// (directly or indirectly)\

// Sort the numbers
// Look at neighbors

// If two neighbors differ by ≤ limit,
// they are in the same group

// If difference > limit,
// group breaks

// Inside each group:
// Sort the indices
// Sort the values
// Put smallest values into smallest indices