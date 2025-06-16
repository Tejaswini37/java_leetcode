class Solution {
    public void sum(int i,int[] a, int target,ArrayList<Integer> t,List<List<Integer>> ans){
        if(target<0) return;
        if(target==0){
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        for(int j=i;j<a.length;j++){
            if(j>i && a[j]==a[j-1]) continue;
            if(target<a[j]) break;
            t.add(a[j]);
            sum(j+1,a,target-a[j],t,ans);
            t.remove(t.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
    
        Arrays.sort(candidates);
        sum(0,candidates,target,new ArrayList<>(),ans);
        return ans;
    }
}

// If you're are wondering why didn't he solve this problem using the similar concept that he used in Combination Sum 1 then read this:

// You can actually do it using the same technique as of that problem, which would be the correct solution and since you already are familiar with that technique, it makes sense for you to use that technique only. But the thing is that Leetcode is not accepting the solution, and would throw you a TLE. So you have to use this new technique which is much better and optimised. 

// However, if you want to see the solution of this problem with the Combination Sum 1 Technique then here you go:

// class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         Arrays.sort(candidates);
//         Set<List<Integer>> result = new HashSet();
//         result = findSum(0,candidates,target,result,new ArrayList());
//         List<List<Integer>> ans = new ArrayList(result);
//         return ans;
//     }
    
//     public Set<List<Integer>> findSum(int index, int[] candidates, int target, Set<List<Integer>> result, List<Integer> list){
//         if(index>=candidates.length){
//             if(target==0) result.add(list);
//             return result;
//         } 
        
//         list.add(candidates[index]);
//         findSum(index+1,candidates,target-candidates[index],result,new ArrayList(list));
//         list.remove(list.size()-1);
//         findSum(index+1,candidates,target,result,new ArrayList(list));
//         return result;
//     }
    
// }