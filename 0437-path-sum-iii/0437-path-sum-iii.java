/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int dfs(TreeNode root,Map<Long,Integer> prefixSum,long curSum,int target){
        if(root==null) return 0;
        curSum+=root.val;
        int c=prefixSum.getOrDefault(curSum-target,0);
        prefixSum.put(curSum,prefixSum.getOrDefault(curSum,0)+1);
        c+=dfs(root.left,prefixSum,curSum,target);
        c+=dfs(root.right,prefixSum,curSum,target);
        //backTrack
        prefixSum.put(curSum,prefixSum.get(curSum)-1);
        return c;
    }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> prefixSum=new HashMap<>();
        prefixSum.put(0L,1);
        return dfs(root,prefixSum,0L,targetSum);
    }
}
// class Solution {
//     public int pathSum(TreeNode root, int targetSum) {
//         if (root == null) return 0;
//         return dfs(root, targetSum) 
//              + pathSum(root.left, targetSum) 
//              + pathSum(root.right, targetSum);
//     }

//     private int dfs(TreeNode node, long target) {
//         if (node == null) return 0;
//         int count = 0;
//         if (node.val == target) count++;
//         count += dfs(node.left, target - node.val);
//         count += dfs(node.right, target - node.val);
//         return count;
//     }
// }
