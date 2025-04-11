class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int n=arr.length;
        Arrays.sort(arr);
        long ans=0;
        for(int i=0;i<n-2;i++){
            int sum=target-arr[i];
            int l=i+1,r=n-1;
            while(l<r){
                if(arr[l]+arr[r]>sum) r--;
                else if(arr[l]+arr[r]<sum) l++;
                else{
                    int c1=1,c2=1;
                    if(arr[l]==arr[r]){
                        int len=r-l+1;
                        ans+=(len*(len-1)/2);
                        break;
                    }
                    while(l<r && arr[l]==arr[l+1]) {
                        c1++;
                        l++;
                    }
                    while(l<r && arr[r]==arr[r-1]){
                        c2++;
                        r--;
                    }
                    ans+=(c1*c2);
                    l++;
                    r--;
                }
            }
        } 
        return (int)(ans%1000000007);  
    }
}