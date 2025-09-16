class Solution {
    public int gcd(int a,int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st=new Stack<>();
        for(int n: nums){
            st.add(n);
            while(st.size()>1){
                int a=st.get(st.size()-1);
                int b=st.get(st.size()-2);
                int g=gcd(a,b);
                if(g==1) break;
                st.remove(st.size()-1);
                st.remove(st.size()-1);
                long lcm=(long) a/g *b;
                st.add((int)lcm);
            }
        }
        return st;
    }
}
// Two numbers are non-coprime if their GCD (Greatest Common Divisor) > 1.