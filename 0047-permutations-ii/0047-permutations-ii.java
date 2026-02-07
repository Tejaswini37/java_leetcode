// class Solution {
//     List<List<Integer>> res;
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         res=new ArrayList<>();
//         Arrays.sort(nums);
//         bt(nums,new ArrayList<>());
//         return res;
//     }
//     void bt(int nums[],List<Integer> temp){
//         if(temp.size()==nums.length){
//             res.add(new ArrayList<>(temp));
//             return;
//         }
//         for(int i=0;i<nums.length;i++){
//             if(temp.contains(nums[i])) continue;   // wrong solution when duplictes
//             // [1,1,2] u add 1 , u can't add second one beacuse it contains
//             // skip duplicates
//             if(i>0 && nums[i]==nums[i-1] && !temp.contains(nums[i-1])) continue;
//             temp.contains(nums[i]);
//             bt(nums,temp);
//             temp.remove(temp.size()-1);
//         }
//     }
// }
// Time: O(n! × n) (extra contains)
// Space: O(n)
class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);               // Step 1
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, boolean[] visited, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) continue;

            // 🔥 duplicate skip condition
            // “Don’t pick a duplicate unless its previous copy is already used.”
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            visited[i] = true;
            temp.add(nums[i]);

            backtrack(nums, visited, temp);

            temp.remove(temp.size() - 1);
            visited[i] = false;
        }
    }
}
