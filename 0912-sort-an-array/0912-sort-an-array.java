class Solution {
    private void mergeSort(int a[],int l,int r){
        if(l>=r) return;
        int mid=l+(r-l)/2;
        mergeSort(a,l,mid);
        mergeSort(a,mid+1,r);
        merge(a,l,mid,r);
    }
    public void merge(int a[],int l,int m,int r){
        int temp[]=new int[r-l+1];
        int i=l,j=m+1,k=0;
        while(i<=m && j<=r){
            if(a[i]<=a[j]) temp[k++]=a[i++];
            else temp[k++]=a[j++];
        }
        while(i<=m) temp[k++]=a[i++];
        while(j<=r) temp[k++]=a[j++];
        for(int x=0;x<k;x++){
            a[x+l]=temp[x];
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}


 
