class Solution {
    public void subs(int i,int n,int[] nums,List<Integer> temp,List<List<Integer>> l){
        if(i==n){
            ArrayList<Integer> t=new ArrayList<>(temp);
            l.add(t);
            return;
        }
        temp.add(nums[i]);
        subs(i+1,n,nums,temp,l);
        temp.remove(temp.size()-1);
        subs(i+1,n,nums,temp,l);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> l=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        subs(0,nums.length,nums,temp,l);
        return l;
    }
}

// 1. Print All the Subsequence
// 2. Print all Sq which sums to K
// 3. Print only 1st Sq which sums to K
// 4. Print the count of Sq which sums to K