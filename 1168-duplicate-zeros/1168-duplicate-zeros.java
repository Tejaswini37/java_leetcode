class Solution {
    public void duplicateZeros(int[] arr) {
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                int r=arr.length-1;
                while(i<r){
                    arr[r]=arr[r-1];
                    r--;
                }
                i++;
            }
            
        }
    }
}