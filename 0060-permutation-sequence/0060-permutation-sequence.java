class Solution {
    public String getPermutation(int n, int k) {
        int fact=1;
        List<Integer> nums=new ArrayList<>();
        for(int i=1;i<n;i++){// starting with 1=6,2=6,3=6,4=6 
        // (n-1)!=6 store 6 in fact
            fact*=i;
            nums.add(i);
        }
        nums.add(n);
        k=k-1;
        String ans="";
        while(true){
            ans=ans+nums.get(k/fact);
            nums.remove(k/fact);
            if(nums.size()==0) break;
            k=k%fact;
            fact=fact/nums.size();
        }
        return ans;
    }
}
// generate all permutations using bt and sort them and return kth permutation sorted_list[k-1]  //brute force  n!*n + sort