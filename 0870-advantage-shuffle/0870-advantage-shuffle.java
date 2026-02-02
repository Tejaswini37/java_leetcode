class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int res[]=new int[n];
        Arrays.fill(res,-1);
        int n2[][]=new int[n][2];
        for(int i=0;i<n;i++){
            n2[i][1]=nums2[i];
            n2[i][0]=i;
        }
        Arrays.sort(nums1);
        Arrays.sort(n2,(a,b)->a[1]-b[1]);
        List<Integer> temp=new ArrayList<>();
        int k1=0,k2=0;
        for(int i=0;i<n;i++){
            if(n2[k1][1]<nums1[i]){
                res[n2[k1][0]]=nums1[i];
                k1++;
            }
            else temp.add(nums1[i]); //store 
        }
        int idx=0;
        for(int i=k1;i<n;i++){
            res[n2[i][0]]=temp.get(idx++);
        }
        return res;

    }
}