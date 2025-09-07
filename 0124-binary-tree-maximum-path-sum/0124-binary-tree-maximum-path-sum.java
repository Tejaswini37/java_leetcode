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
    public int findPath(TreeNode root,int maxi[]){
        if(root==null) return 0;
        int leftMax=Math.max(findPath(root.left,maxi),0);
        int rightMax=Math.max(findPath(root.right,maxi),0);
        maxi[0]=Math.max(maxi[0],leftMax+rightMax+root.val);
        return Math.max(leftMax,rightMax)+root.val;
    }
    public int maxPathSum(TreeNode root) {
        int maxi[]={Integer.MIN_VALUE};
        findPath(root,maxi);
        return maxi[0];
    }
}