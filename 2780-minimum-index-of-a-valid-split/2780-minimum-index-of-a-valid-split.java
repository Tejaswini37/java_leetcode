class Solution {
    public int minimumIndex(List<Integer> nums) {
        int c=0,dom=0;
        for(int x : nums){
            if(c==0){
                dom=x;
                c++;
            }
            else if(x==dom) c++;
            else c--;
        }
        int freq=0;
        for(int x : nums){
            if(x==dom) freq++;
        }
        int left=0;
        int n=nums.size();
        for(int i=0;i<n-1;i++){
            if(nums.get(i)==dom) left++;
            int right=freq-left;
            int leftsize=i+1;
            int rightsize=n-i-1;
            if(2*left>leftsize && 2*right>rightsize) return i;
        }
        return -1;
    }
}
// Step 1️⃣ Find the dominant element (Boyer–Moore Voting)
// Step 2️⃣ Count its total frequency
// Step 3️⃣ Try all split points
// For each index i:
// Let leftCount = occurrences in [0..i]
// Let rightCount = totalCount - leftCount

// Check:

// leftCount * 2 > (i + 1)
// rightCount * 2 > (n - i - 1)