class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int tar=threshold*k;
        int sum=0,count=0;
        for(int i=0;i<k;i++) sum+=arr[i];
        if(sum>=tar) count++;
        for(int i=k;i<arr.length;i++){
            sum+=(arr[i]-arr[i-k]);
            if(sum>=tar) count++;
        }
        return count;
    }
}
