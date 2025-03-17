class Solution {
    public int maxChunksToSorted(int[] arr) {
        int c=0;
        int sum=0;
        int expected=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            expected+=i;
            if(sum==expected) c++;
        }
        return c;
        
    }
}