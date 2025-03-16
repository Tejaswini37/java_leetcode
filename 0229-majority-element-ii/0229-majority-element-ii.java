class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int n=nums.length;
        List<Integer> res=new ArrayList<>();
        int m1=0,m2=0,c1=0,c2=0;
        for(int x:nums){
            if(x==m1) c1++;
            else if(x==m2) c2++;
            else if(c1==0){
                m1=x;
                c1++;
            }
            else if(c2==0){
                m2=x;
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1=0;
        c2=0;
        for(int x:nums){
            if(x==m1) c1++;
            else if(x==m2) c2++;
        }
        if(c1>n/3) res.add(m1);
        if(c2>n/3) res.add(m2);
        return res;
    }
}