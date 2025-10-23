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
    public void preorder(List<Integer> pre, TreeNode root){
        if(root==null) return;
        pre.add(root.val);
        preorder(pre,root.left);
        preorder(pre,root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> pre=new ArrayList<>();
        preorder(pre, root);
        return pre;
    }
}