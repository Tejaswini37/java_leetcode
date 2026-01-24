class Solution {
    public int minOperations(int[] nums) {
        int ans=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int n : nums){
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        for(int f : hm.values()){
            if(f==1) return -1;
            // if(f%3==0) ans+=f/3;
            // else ans+=f/2;
            // wrong because if 7 =3+2+2 ans=3
            // if(f%3==0) 
            ans+=f/3;
            if(f%3==1 || f%3==2) ans++;
            // or ans+=(f+2)/3;
            
        }
        return ans;
    }
}