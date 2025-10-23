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
    public void inorder(List<Integer> in, TreeNode root){
        if(root==null) return;
        inorder(in,root.left);
        in.add(root.val);
        inorder(in,root.right);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> in=new ArrayList<>();
        inorder(in, root);
        return in;
    }
}