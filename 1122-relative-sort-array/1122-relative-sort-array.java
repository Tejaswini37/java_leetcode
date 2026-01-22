class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int freq[]=new int[1001];
        for(int x: arr1){
            freq[x]++;
        }
        int idx=0;
        for(int x : arr2){
            while(freq[x]-->0){
                arr1[idx++]=x;
                // idx++;
            }
        }
        for(int i=0;i<1001;i++){
            while(freq[i]-->0){
                arr1[idx++]=i;
            }
        }
        return arr1;
    }
}