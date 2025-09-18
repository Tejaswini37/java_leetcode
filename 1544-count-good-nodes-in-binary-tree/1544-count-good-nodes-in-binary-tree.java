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
    public int dfs(TreeNode root,int maxVal){
        if(root==null) return 0;
        int c=0;
        if(root.val>=maxVal) c=1;
        maxVal=Math.max(root.val,maxVal);
        c+=dfs(root.left,maxVal);
        c+=dfs(root.right,maxVal);
        return c;
    }
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }
}