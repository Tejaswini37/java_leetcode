class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int l=0,h=0;
        for(int i=0;i<n;i++){
            l=Math.max(l,weights[i]);
            h+=weights[i];
        }
        while(l<=h){
            int mid=(l+h)/2;
            int d=1, load=0;

            for(int i=0;i<n;i++) {
                if(load+weights[i]>mid){
                    d++;
                    load=weights[i];
                }
                else load+=weights[i];
            }
            if(d>days) l=mid+1;
            else h=mid-1;
        }
        return l;
    }
}