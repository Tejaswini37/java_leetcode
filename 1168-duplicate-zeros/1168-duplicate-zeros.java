class Solution {
    public void duplicateZeros(int[] arr) {
        
        // for(int i=0;i<arr.length;i++){
        //     if(arr[i]==0){
        //         int r=arr.length-1;
        //         while(i<r){
        //             arr[r]=arr[r-1];
        //             r--;
        //         }
        //         i++;
        //     }
            
        // }
        //o(n)
        List<Integer> l=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            l.add(arr[i]);
            if(arr[i]==0){
                l.add(0);
            }
        }
        for(int i=0;i<n;i++){
            arr[i]=l.get(i);
        }
    }
}