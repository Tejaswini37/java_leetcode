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
        // List<Integer> l=new ArrayList<>();
        // int n=arr.length;
        // for(int i=0;i<n;i++){
        //     l.add(arr[i]);
        //     if(arr[i]==0){
        //         l.add(0);
        //     }
        // }
        // for(int i=0;i<n;i++){
        //     arr[i]=l.get(i);
        // }
        //two-pointer
        int  n=arr.length;
        int zeroes=0;
        for(int i=0;i<n;i++){
            if(arr[i]==0) zeroes++;
        }
        int last_i=n-1;
        int new_i=n-1+zeroes;
        while(last_i>=0){
            if(new_i<n){
                arr[new_i]=arr[last_i];
            }
            if(arr[last_i]==0){
                new_i--;
                if(new_i<n) arr[new_i]=0;
            }
            last_i--;
            new_i--;
        }
    }
}