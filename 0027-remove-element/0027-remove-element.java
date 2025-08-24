class Solution {
    public int removeElement(int[] a, int val) {
        int i=0;
        for(int j=0;j<a.length;j++){
            if(a[j]!=val){
                a[i]=a[j];
                i++;
            }
        }
        return i;
    }
}