class Solution {
    public int lowerBound(int a[],long tar){
        int l=0,r=a.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(a[mid]<tar) l=mid+1;
            else r=mid;
        }
        return l;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int m=potions.length;
        int res[]=new int[spells.length];
        for(int i=0;i<spells.length;i++){
            long minPotion=(success+spells[i]-1)/spells[i];// ceil(success/spell)
            int idx=lowerBound(potions,minPotion);
            res[i]=m-idx;
        }
        return res;
    }
}